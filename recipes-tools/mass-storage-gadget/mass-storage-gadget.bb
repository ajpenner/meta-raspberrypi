SUMMARY = "Raspberry Pi Add mass storage device"
HOMEPAGE = "https://www.freedesktop.org/wiki/Software/systemd/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PR = "r5"

S = "${WORKDIR}"
filename = "piusb.bin"

do_builod() {
    # In future we want the name and size from conf/local.conf
    dd bs=1M if=/dev/zero of="${filename}" count=256
    mkdosfs "${filename}"
}

do_install() {
    install -m 0644 ${WORKDIR}/${filename} ${D}/${filename}
}

# This is a machine specific file
FILES:${PN} = "\
    ${filename} \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
