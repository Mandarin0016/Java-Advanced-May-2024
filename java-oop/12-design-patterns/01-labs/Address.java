public class Address {
    private String name;
    private String telephone;
    private String addersLineOne;
    private String addersLineTwo;
    private String email;
    private String postCode;
    private String countryCode;
    private String region;

    private Address() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Address address;

        public Builder() {
            this.address = new Address();
        }

        public Builder setName(String name) {
           address.name = name;
           return this;
        }

        public Builder setTelephone(String telephone) {
            address.telephone = telephone;
            return this;
        }

        public Builder setAddersLineOne(String addersLineOne) {
            address.addersLineOne = addersLineOne;
            return this;
        }

        public Builder setAddersLineTwo(String addersLineTwo) {
            address.addersLineTwo = addersLineTwo;
            return this;
        }

        public Builder setEmail(String email) {
            address.email = email;
            return this;
        }

        public Builder setPostCode(String postCode) {
            address.postCode = postCode;
            return this;
        }

        public Builder setCountryCode(String countryCode) {
            address.countryCode = countryCode;
            return this;
        }

        public Builder setRegion(String region) {
            address.region = region;
            return this;
        }

        public Address build() {
            return address;
        }
    }
}
