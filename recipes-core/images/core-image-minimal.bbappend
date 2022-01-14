SUMMARY = "Additional packages."

# Add bash
IMAGE_INSTALL += " \
  bash \
"

# For wireless support
IMAGE_INSTALL += " \
    linux-firmware-bcm43430 \
    wpa-supplicant \
    bluez5 \
    udev-rules-rpi \
    i2c-tools \
    iptables \
    rpio \
    rpi-gpio \
"

# RNDIS
IMAGE_INSTALL += " \
  openssh \
  rndis \
"

