interface USBADevice
{
    void connectUSBAPort();
}

class USBCPort {
    void connectUSBCPort()
    {
        System.out.println("Connected to USB-C port.");
    }
}

class USBCtoUSBAAdapter implements USBADevice
{
    private USBCPort usbcPort;

    public USBCtoUSBAAdapter(USBCPort usbcPort)
    {
        this.usbcPort = usbcPort;
    }

    @Override
    public void connectUSBAPort()
    {
        usbcPort.connectUSBCPort();
        System.out.println("Adapter converts USB-C to USB-A.");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        USBCPort usbcPort = new USBCPort();
        USBADevice usbDevice = new USBCtoUSBAAdapter(usbcPort);

        usbDevice.connectUSBAPort();
    }
}