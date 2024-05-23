.DEFAULT_GOAL := build-run
.PHONY: build app

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist: install
	@./build/install/app/bin/app

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release

build-run: run-dist
