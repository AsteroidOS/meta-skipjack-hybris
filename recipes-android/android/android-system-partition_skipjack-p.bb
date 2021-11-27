inherit gettext

SUMMARY = "Downloads the TicWatch C2+ system folders and installs them for libhybris"
LICENSE = "CLOSED"

SRC_URI = "file://WiFi-Skipjack.tar.gz"
SRC_URI[md5sum] = "d28a0dce537f996ce475ff729b4ee74d"
SRC_URI[sha256sum] = "f5253b286c90f94a23158290c1df8cc9a9a8962148a0249cd7314a3762b89e8a"
PV = "pie"

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"
COMPATIBLE_MACHINE = "skipjack"
INSANE_SKIP:${PN} = "ldflags dev-so already-stripped"
S = "${WORKDIR}"
B = "${S}"

PROVIDES += "virtual/android-system-partition"

do_install() {
    install -d ${D}/system/
    cp -r system/* ${D}/system/

    cd ${D}
    ln -s system/vendor vendor
}

do_package_qa() {
}

FILES:${PN} = "/system /vendor"
EXCLUDE_FROM_SHLIBS = "1"
