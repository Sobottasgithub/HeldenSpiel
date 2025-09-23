{
  description = "HeldenSpiel development shell with JDK";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
  };

  outputs =
    { self, nixpkgs }:
    let
      system = "x86_64-linux";
      pkgs = import nixpkgs { inherit system; };
      maven = pkgs.maven;
      jdk = pkgs.jdk23.override {
        enableJavaFX = true;
      };
    in
    {
      packages.${system} = {
        inherit jdk;
        default = maven.buildMavenPackage {
          pname = "HeldenSpiel";
          version = "1.0.0";
          src = ./.;
          mvnHash = "sha256-1cBre3AvOXD5F77jTKr8lxoEoEuM7Zaa0l1+7Xj2BzU=";
          mvnJdk = jdk;

          nativeBuildInputs = [ pkgs.makeWrapper ];

          installPhase = ''
            shopt -s nullglob
            set -euo pipefail

            mkdir -p $out/share/HeldenSpiel

            jars=(./target/*.jar)
            if [ ''${#jars[@]} -eq 0 ]; then
              echo "No JAR file found? Maven install works?" >&2
              exit 1
            elif [ ''${#jars[@]} -gt 1 ]; then
              echo "Multiple JAR files found: ''${jars[*]}" >&2
              exit 1
            else
              JAR="''${jars[0]}"
            fi
            echo "Found JAR: ''$JAR"
            cp $JAR $out/share/HeldenSpiel/
            JAR_NAME=$(basename $JAR)

            mkdir -p $out/bin
            echo "Wrapping $JAR_NAME"
            makeWrapper ${pkgs.lib.getExe jdk} $out/bin/heldenspiel --add-flags "-jar $out/share/HeldenSpiel/$JAR_NAME"
          '';
          meta = {
            mainProgram = "heldenspiel";
          };
        };
      };
      devShells.${system}.default = pkgs.mkShell {
        buildInputs = [
          jdk
          pkgs.google-java-format
          pkgs.findutils
          pkgs.scenebuilder
          pkgs.xmlindent
          maven
        ];

        shellHook = '''';
      };
    };
}
