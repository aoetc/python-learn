class Address {
    private String province, city, street, zip;

    Address(String province, String city, String street, String zip) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.zip = zip;
    }

    void printAddrInfo() {
        System.out.println(province + " " + city + " " + street + " " + zip);
    }
}

class Client {
    private String name;
    private Address address;

    Client(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    void modifyAddr(Address address) { this.address = address; }
    Address getAddr() { return address; }

    void print() {
        System.out.println("客户: " + name);
        address.printAddrInfo();
    }
}

public class Ans_AddressClient {
    public static void main(String[] args) {
        Client c = new Client("张三",
                new Address("浙江", "杭州", "文一路", "310000"));
        c.print();
        c.modifyAddr(new Address("浙江", "杭州", "学院路", "310018"));
        System.out.println("修改后:");
        c.print();
    }
}
