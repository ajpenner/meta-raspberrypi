#
# This file is the RNDIS recipe
#

SUMMARY = "RNDIS service starts on boot"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = " \
	file://rndis.service \
	file://rndis.sh \
"

inherit systemd

SYSTEMD_SERVICE_${PN} = "rndis.service"

RDEPENDS:${PN} += "bash"

do_install() {
    install -d -D ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/rndis.service ${D}${systemd_system_unitdir}

    install -d -D ${D}${sysconfdir}/rndis
    install -m 0755 ${WORKDIR}/rndis.sh ${D}${sysconfdir}/rndis/rndis.sh
}

FILES:${PN} += " \
    ${sysconfdir}/rndis/rndis.sh \
    ${systemd_system_unitdir}/rndis.service \
"
