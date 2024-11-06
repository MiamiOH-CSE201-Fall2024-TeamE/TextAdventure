build: bin dist
	cd bin && jar cfmv ZombieManor.jar ../Manifest.mf *
	cd bin && move ZombieManor.jar ../dist
	cd dist && $ (echo @echo off && echo java -jar ZombieManor.jar) > run.bat

bin:
	cd src && javac -d ../bin app/App.java

dist:
	mkdir dist

run: bin
	cd bin && java app.App

clean:
	rm -rf bin
	rm -rf dist