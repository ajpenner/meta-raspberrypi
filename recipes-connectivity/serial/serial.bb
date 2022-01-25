SUMMARY = "Raspberry Pi Serial terminal support for systemd"
HOMEPAGE = "https://www.freedesktop.org/wiki/Software/systemd/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PR = "r5"

S = "${WORKDIR}"

# As this package is tied to systemd, only build it when we're also building systemd.
inherit features_check
REQUIRED_DISTRO_FEATURES = "systemd"

do_install() {
	install -d ${D}${sysconfdir}/systemd/system/getty.target.wants/

	# enable the service
	ln -sf ${systemd_system_unitdir}/getty@.service \
		${D}${sysconfdir}/systemd/system/getty.target.wants/getty@ttyGSO.service
}

# This is a machine specific file
FILES:${PN} = "\
    ${sysconfdir}\
"
PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY:${PN} = "1"
