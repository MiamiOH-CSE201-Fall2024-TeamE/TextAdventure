build: bin dist
	cd bin && jar cfmv ZombieManor.jar ../Manifest.mf *
	cd bin && mv ZombieManor.jar ../dist
	cd dist && $ (echo "@echo off" && echo "java -jar ZombieManor.jar" && echo "pause") > run.bat
	cd dist && $ (echo "#!/bin/bash" && echo "java -jar ZombieManor.jar" && echo "read -p "Press any key to continue..." -n1 -s") > run.sh
	cd dist && chmod +x run.sh

bin:
	cd src && javac -d ../bin app/App.java

dist:
	mkdir dist

run: bin
	cd bin && java app.App

clean:
	rm -rf bin
	rm -rf dist
