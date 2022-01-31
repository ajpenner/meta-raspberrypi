SUMMARY = "Additional packages."

# Add bash
IMAGE_INSTALL += " \
  bash \
"

# For wireless support
IMAGE_INSTALL += " \
    linux-firmware-bcm43430 \
    wpa-supplicant \
    udev-rules-rpi \
    i2c-tools \
    iptables \
    rpio \
    rpi-gpio \
    kea \
    dhcpcd \
"

# COMMS
IMAGE_INSTALL += " \
  packagegroup-core-ssh-openssh \
  serial-gadget \
  ether-gadget \
  mass-storage-gadget \
"
