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
      jdk = pkgs.jdk.override {
        enableJavaFX = true;
      };
    in
    {
      packages.${system} = {
        inherit jdk;
      };
      devShells.${system}.default = pkgs.mkShell {
        buildInputs = [
          jdk
          pkgs.google-java-format
          pkgs.findutils
          pkgs.scenebuilder
          pkgs.maven
        ];

        shellHook = '''';
      };
    };
}
