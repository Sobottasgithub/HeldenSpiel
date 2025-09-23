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
          mvnHash = "";
          mvnJdk = jdk;
        };
      };
      devShells.${system}.default = pkgs.mkShell {
        buildInputs = [
          jdk
          pkgs.google-java-format
          pkgs.findutils
          pkgs.scenebuilder
          maven
        ];

        shellHook = '''';
      };
    };
}
