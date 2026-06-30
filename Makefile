# VPN OVER SSH - Makefile

BUILD_DIR = app/build
APK_PATH = ${BUILD_DIR}/outputs/apk/debug/app-debug.apk
AVD_NAME = Pixel_API_35

.PHONY: build install emulator clean

build:
	./gradlew clean assemble --no-daemon

install:
	adb install -r $(APK_PATH)

emulator:
	emulator -avd $(AVD_NAME) -no-snapshot -wipe-data &

clean:
	./gradlew clean --no-daemon
	rm -rf $(BUILD_DIR)
