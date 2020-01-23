final class Person {

    private final int id;
    private final String name;
    private final String address;

    private boolean isSeniorCitizen;

    private Person(PersonBuilder personBuilder)
    {
        this.id=personBuilder.id;
        this.name=personBuilder.name;
        this.address=personBuilder.address;
        this.isSeniorCitizen=personBuilder.isSeniorCitizen;
    }

    public static class PersonBuilder{
        int id;
        String name;
        String address;

        boolean isSeniorCitizen;

        PersonBuilder(){

        }

        /*
        This parameterized constructor is to make those mandatory parameters
        for the object creation.
        Setter method makes an attribute optional for the class.
         */
        public PersonBuilder(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public PersonBuilder isSeniorCitizen() {
            return this;
        }

        public PersonBuilder setSeniorCitizen(boolean seniorCitizen) {
            isSeniorCitizen = seniorCitizen;
            return this;
        }

        public static PersonBuilder personBuilder(){
            return new PersonBuilder();
        }


        public Person build()
        {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person person=Person.PersonBuilder.personBuilder().setSeniorCitizen(true).build();

        System.out.println(person.isSeniorCitizen);
    }
}
