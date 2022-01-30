#
# This file is the ether-gadget recipe
#

SUMMARY = "Ethernet over usb service starts on boot"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = " \
	file://ether-gadget.service \
	file://ether-gadget.sh \
	file://interfaces \
"

inherit systemd

SYSTEMD_SERVICE:${PN} = "ether-gadget.service"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"

RDEPENDS:${PN} += "bash"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/ether-gadget.service ${D}${systemd_system_unitdir}/ether-gadget.service

    install -d -D ${D}${sysconfdir}/ether-gadget
    install -m 0755 ${WORKDIR}/ether-gadget.sh ${D}${sysconfdir}/ether-gadget/ether-gadget.sh

    install -d -D ${D}${sysconfdir}/network
    install -m 0755 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
}

FILES:${PN} += " \
    ${sysconfdir}/ether-gadget/ether-gadget.sh \
    ${systemd_system_unitdir} \
    ${sysconfdir}/network/interfaces \
"

COMPATIBLE_MACHINE = "^rpi$"
PACKAGE_ARCH = "${MACHINE_ARCH}"
