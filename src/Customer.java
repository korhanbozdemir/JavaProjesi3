public class Customer {


    private Integer customerId;
    private String firstName;
    private String lastName;
    private String city;

    private static Integer sayac=0;



    public Customer(String firstName, String lastName, String city) {
        sayac=sayac+1000;
        this.customerId=sayac;
        setFirstName(firstName);
        setLastName(lastName);
        setCity(city);

    }

    public Customer() {

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Çalışan Id=" + customerId +
                ", Ad='" + firstName + '\'' +
                ", Soyad='" + lastName + '\'' +
                ", İl='" + city +'\'' ;
    }

    // FIELDS   //////////////////////////////////////////////////////////////////////
    /** TÜM FIELD LAR PRIVATE OLMALIDIR. FINAL OLMAYACAK.
     * customerId Integer,
     * firstName, lastName, city String OLACAK
     */

    ///////////////////////////////////////////////////////////////////////////////////


    // CONSTRUCTORS //////////////////////////////////////////////////////////////////

    /** BOŞ CONSTRUCTOR OLUŞTURUN*/

    /** PARAMTRELERİ int customerId, String firstName, String lastName, String city
     * OLAN CONSTRUCTOR OLUŞTURUN... */

    ////////////////////////////////////////////////////////////////////////////////////



    // GETTER SETTER METHODS    ///////////////////////////////////////////////////////
    /** GETTER VE SETTER METODLARI OLUŞTURUN    */

    ////////////////////////////////////////////////////////////////////////////////



    // TO STRING METHOD ////////////////////////////////////////////////////////////

    /** TO STRING METODU OLUŞTURUN  */
    /////////////////////////////////////////////////////////////////////////////////
}
