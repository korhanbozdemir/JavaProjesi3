import java.util.*;

public class BankSimulation {

    Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Customer> customers=new HashMap<>();
    private static final ArrayList<Account> accounts=new ArrayList<>();
    private static int syc=0;

    /**
     * NOT //////////////////////////////////////////////////////////////////////////////////////////////
     * Aşağıdaki üç field'ın (customers,accounts,scanner) final olması ilk bakışta
     * "bu listeler değiştirilemez olursa, bunlara nasıl müşteri veya hesap ekleriz?"
     * gibi bir soru akla getirebilir.
     * Ancak burada değiştirilemeyecek olan, değerlerin içi değil, referansıdır...
     * `BankSimulation` sınıfı içindeki `accounts` ve `customers` dizi-değişkenlerinin
     * `final` olmasının nedeni, bu değişkenlere atanan referansların sonradan değiştirilmesini engellemek
     * ve programın daha güvenli ve kontrol edilebilir olmasını sağlamaktır.
     * `final` anahtar kelimesiyle tanımlanan bir değişkenin değeri sadece bir kez atanabilir
     * ve sonradan değiştirilemez.
     * Bu tanımlama, `customers` değişkeninin referansının değiştirilemeyeceği anlamına gelir.
     * Ancak, `customers` değişkenine atanan `HashMap` nesnesinin içeriği yine de değiştirilebilir.
     * Yani, `customers` değişkeninin referansı aynı kalacak şekilde müşteri bilgileri eklenebilir,
     * güncellenebilir veya silinebilir.
     * ////////////////////////////////////////////////////////////////////////////////////////////////
     */
    // FIELDS ///////////////////////////////////////////////////////////////////////////////////////


    /**
     * AÇIKLAMADA BELİRTİLEN FIELD LARI OLUŞTURUN...
     */
    ////////////////////////////////////////////////////////////////////////////////////////////////

    // CONSTRUCTORS     ////////////////////////////////////////////////////////////////////////////
    // public BankSimulation() metodu bir constructor'dır.
    // Constructor, bir sınıfın nesnesi oluşturulduğunda otomatik olarak çağrılan bir metottur
    // ve nesnenin başlatılması için kullanılır.
    // BankSimulation sınıfındaki bu constructor,
    // sınıfın nesnesi oluşturulduğunda müşteri ve hesapları saklamak için
    // customers ve accounts değişkenlerini uygun şekilde başlatır.
    // Aynı zamanda kullanıcıdan girdiler almak için scanner değişkenini de başlatır.
    // Bu constructor sayesinde, BankSimulation sınıfından bir nesne oluşturduğunuzda,
    // müşteri ve hesap verilerini saklamak ve kullanıcıdan girdiler almak için gerekli olan
    // başlangıç durumu hazırlanmış olur.
    public BankSimulation(){

    }

/*    public BankSimulation() {
        this.customers = new HashMap<>();
        this.accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }*/


    public Scanner getOku() {
        return scanner;
    }

    public void setOku(Scanner oku) {
        this.scanner = scanner;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }


    /**
     * AÇIKLAMADA BELİRTİLEN CONSTRUCTORLARI OLUŞTURUN...
     */


    ///////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws InterruptedException {

        BankSimulation bs = new BankSimulation();
        bs.run();



        /** BANKSIMULATION SINIFININ NESNESİNİ OLUŞTURUNUZ;*/
        /** RUN METODUNU ÇAĞIRINIZ */

    }

    // public void run() METODU, ÇIKIŞ YAPILANA KADAR ÇALIŞACAK OLAN ANA METOD ////////////////
    public void run() throws InterruptedException {
        do {/** ANA MENÜYÜ OLUŞTURUN VE MÜŞTERİYE YAPTIRDIĞINIZ SEÇİMLERLE, İLGİLİ METODLARA YÖNLENDİRİN...*/

            System.out.println("\n----- BANKA İŞLEMLERİ -----");
            System.out.print("\n1. Müşteri Listele" +
                    "\n2. Yeni Müşteri Ekle" +
                    "\n3. Müşteri İşlemleri" +
                    "\n0. Çıkış" +
                    "\nSeçiminizi yapın: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listCustomers();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    customerOperationsMenu();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }
        } while (true);


        /** MÜŞTERİ ÇIKIŞ YAPMADIĞI SÜRECE MENÜDE KALMAYA DEVAM ETSİN...*/

    }
    ///////////////////////////////////////////////////////////////////////////////////////////


    // MÜŞTERİLERİ LİSTELEYECEK OLAN METHOD ///////////////////////////////////////////////////
    public void listCustomers() throws InterruptedException {
        System.out.println("\n----- MÜŞTERİLER -----");

        /** MÜŞTERİLERİ LİSTELEYECEK ŞEKİLDE METODU DOLDURUNUZ... */

        for (Map.Entry<Integer, Customer> customer : customers.entrySet()) // entrySet() keys+values
        {
            System.out.println("*****************************");
            System.out.println(customer.getKey()+" - "+customer.getValue().getFirstName()+" - "+customer.getValue().getLastName()+" ("+customer.getValue().getCity()+")");
           // listCustomerAccounts(customer.getValue());
            int a=0;
            for (Account oMusterininAccountu: accounts) {
                if(customer.getValue().getCustomerId()==oMusterininAccountu.getCustomerId() && oMusterininAccountu.getAccountId()>0){
                    System.out.println(oMusterininAccountu.getAccountId()+"-"+oMusterininAccountu.getAccountType()+"-"+oMusterininAccountu.getBalance());
                    a++;
                }
            }
            if (a==0){
                System.out.println("Müşterinin açık hesabı yoktur!");
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////


    // MÜŞTERİLER LİSTELENİRKEN HESAP BİLGİSİ DE LİSTELENMESİ İÇİN GEREKLİ METOD.////////////////
    public void listCustomerAccounts(Customer customer) throws InterruptedException {
        System.out.print(" Hesaplar Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("\n----- " + customer.getCustomerId() +
                " " + customer.getFirstName() +
                " " + customer.getLastName() +
                " HESAPLARI -----");
        int a=0;
        for (Account oMusterininAccountu: accounts) {
            if(customer.getCustomerId()==oMusterininAccountu.getCustomerId() && oMusterininAccountu.getAccountId()>0){
                System.out.println(oMusterininAccountu.getAccountId()+"-"+oMusterininAccountu.getAccountType()+"-"+oMusterininAccountu.getBalance());
                a++;
            }
        }
        if (a==0){
            System.out.println("Müşterinin açık hesabı yoktur!");
        }
        customerOperations(customer);

        /** MÜŞTERİ HESAPLARINI LİSTELEYECEK ŞEKİLDE METODU DOLDURUNUZ... */
    }
    //////////////////////////////////////////////////////////////////////////////////////////////


    // KONSOLDAN İSİM, SOYİSİM VE ŞEHİR BİLGİSİ ALARAK MÜŞTERİ EKLEME METODU. /////////////////////
    public void addCustomer() {
        Scanner str = new Scanner(System.in);
        System.out.println("\n----- YENİ MÜŞTERİ EKLE -----\n");
        System.out.print("İsim giriniz: ");
        String isim = str.nextLine();
        System.out.print("Soyisim giriniz: ");
        String soyisim = str.nextLine();
        System.out.print("Şehir giriniz: ");
        String sehir = str.nextLine();
        Customer customer = new Customer(isim, soyisim, sehir);
        customers.put(customer.getCustomerId(), customer);
        /** KONSOLDAN İSİM, SOYİSİM VE ŞEHİR BİLGİSİ İSTEYİNİZ  */
        /** UNIQUE (TEKİL BİR MÜŞTERİ ID Sİ OLUŞTURUNUZ */
        /** ELDE ETTİĞİNİZ BU BİLGİLERLE YENİ MÜŞTERİ OLUŞTURUNUZ   */
        /** OLUŞTURDUĞUNUZ BİLGİLERİ BU SINIFIN FIELD ALANINDA TANIMLANAN MAP'E EKLEYİNİZ   */

        System.out.println("Müşteri başarıyla eklendi. Müşteri ID: " + customer.getCustomerId());
    }
    /////////////////////////////////////////////////////////////////////////////////////////////


    // ANA MENÜDEN MÜŞTERİ İŞLEMLERİNİ SEÇİNCE KARŞIMIZA ÇIKACAK OLAN METOD /////////////////////
    // HANGİ MÜŞTERİ DEMEK, HANGİ MÜŞTERİ ID'Sİ DEMEK, BU KONTROLÜ YAPMAMIZ GEREK...
    // KONSOLDAN MÜŞTERİ ID Sİ YANLIŞ GİRİLİRSE, GEÇERSİZ MÜŞTERİ MESAJI VE TEKRAR ID İSTEMESİ GEREKECEK...
    public void customerOperationsMenu() throws InterruptedException {
        //int customerId;
        BankSimulation bankSimulation = new BankSimulation();
        Scanner scanner2=new Scanner(System.in);
        do {
            System.out.println("\n----- MÜŞTERİ İŞLEMLERİ -----");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Müşteri ID girin (0 çıkış yapar): ");
            int id = scanner2.nextInt();
            if (id==0) {
                bankSimulation.run();
            }
            for (Map.Entry<Integer, Customer> customer : customers.entrySet()) // entrySet() keys+values
            {
                if (customer.getKey()==id) {
                    bankSimulation.customerOperations(customer.getValue());
                }
            }
            System.out.println("Geçersiz Müşteri ID. Tekrar deneyin.\n");
        } while (true);
        /** KULLANICIDAN (BANKA GİŞE MEMURU) İŞLEM YAPACAĞI MÜŞTERİ ID Sİ İSTEYİN... */
        /** BU ID'NİN MÜŞTERİ LİSTESİNDE OLUP OLMADIĞINI KONTROL EDİN...    */
        /** ID MAP TE YOKSA, "Geçersiz Müşteri ID. Tekrar deneyin." MESAJI VERİN... */

        /** BU BLOK KULLANICI ÇIKMAK İSTEMEDİĞİ SÜRECE DEVAM ETSİN... */
    }
    ///////////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////////////////////
    // customerOperationsMenu() METODUNDA MÜŞTERİ ID'Sİ DOĞRULANIRSA, BANKA MEMURUNUN (KULLANICI)
    // KARŞISINA MÜŞTERİ İŞLEMLERİ GERÇEKLEŞTİREBİLECEĞİ AŞAĞIDAKİ GİBİ BİR MENÜ ÇIKACAK.
    // --- İSİM SOYİSİM 'İN --- İŞLEMLERİ ---
    // 1.Yeni Hesap Aç,
    // 2. Hesapları Listele
    // 3. Para Yatır
    // 4. Para Çek
    // 5. Bakiye Sorgula
    // 0. Ana Menüye Dön
    // Seçiminizi yapın:
    public void customerOperations(Customer customer) throws InterruptedException {

        do{
        System.out.println("\n----- " + customer.getFirstName() +
                " " + customer.getLastName() +
                " İŞLEMLERİ -----");
        System.out.print("1. Yeni Hesap Aç\n2. Hesapları Listele\n3. Para Yatır\n4. Para Çek\n5. Bakiye Sorgula\n0. Ana Menüye Dön\nSeçiminizi yapın: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                openNewAccount(customer);
                break;
            case 2:
                listCustomerAccounts(customer);
                break;
            case 3:
                depositToAccount(customer);
                break;
            case 4:
                withdrawToAccount(customer);
                break;
            case 5:
                checkBalance(customer);
                break;
            case 0:
                run();
                break;
            default:
                System.out.println("Geçersiz seçim! Tekrar deneyin.");
        }}while (true);
        /** MÜŞTERİ İŞLEMLERİ MENÜSÜNÜ EKRANA BASIN VE KULLANICIDAN TERCİH İSTEYİN... */
        /** SEÇİME GÖRE KULLANICIYI AŞAĞIDAKİNE BENZER METODLARLA SEÇTİĞİ OPERASYONA YÖNLENDİRİN... *
         openNewAccount(customer);
         listCustomerAccounts(customer);
         depositToAccount(customer);
         withdrawToAccount(customer);
         checkBalance(customer);
         System.out.println("Ana menüye dönülüyor...");
         System.out.println("Geçersiz seçim! Tekrar deneyin.");
         */

        /** BU BLOK KULLANICI ÇIKMAK İSTEYENE KADAR DEVAM ETSİN... */
    }
    //////////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////////////////////
    // HESAP AÇARKEN, AÇILACAK HESAP TÜRÜNÜ SEÇMEK İÇİN BİR MENÜ OLACAK...
    // HESAP TÜRÜNÜ SEÇTİKTEN SONRA DA, ID ATAYARAK accounts LIST İNE YENİ HESABI EKLEYEN METOD
    public void openNewAccount(Customer customer) throws InterruptedException {
        System.out.println("\n----- YENİ HESAP AÇ -----\n");
        System.out.println("1-"+AccountType.SAVINGS);
        System.out.println("2-"+AccountType.CHECKING);
        System.out.println("3-"+AccountType.CREDIT);
        System.out.println("Hesap Türü Seçin:");
        int choice=scanner.nextInt();

        switch (choice){
            case 1: syc=syc+1;
                int accountId=customer.getCustomerId()+syc;
            Account account=new Account(accountId,customer.getCustomerId(),AccountType.SAVINGS);
            accounts.add(account);

                System.out.print(" Hesap açılıyor...");
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(100);
                    System.out.print(">");
                }

            System.out.println("\nHesap başarıyla açıldı. Hesap Numarası: " + accountId);
            break;
            case 2:syc=syc+1;
                accountId=customer.getCustomerId()+syc;
            Account account1=new Account(accountId,customer.getCustomerId(),AccountType.CHECKING);
            accounts.add(account1);

                System.out.print(" Hesap açılıyor...");
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(100);
                    System.out.print(">");
                }

            System.out.println("\nHesap başarıyla açıldı. Hesap Numarası: " + accountId);
            break;
            case 3:syc=syc+1;
                accountId=customer.getCustomerId()+syc;
            Account account2=new Account(accountId,customer.getCustomerId(),AccountType.CREDIT);
            accounts.add(account2);

                System.out.print(" Hesap açılıyor...");
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(100);
                    System.out.print(">");
                }

            System.out.println("\nHesap başarıyla açıldı. Hesap Numarası: " + accountId);
            break;
            default:
                System.out.println("Geçersiz seçim! Yeni hesap açma işlemi iptal edildi.");
        }

        /** SEÇİM YAPMASI İÇİN KULLANICIYA HESAP TÜRLERİNİ (ENUM) LİSTELEYİN... */
        /** KULLANICIYA KONSOLDAN SEÇİM YAPTIRIN... */
        /** SEÇİLEN DEĞERE GÖRE HESAP TÜRÜNÜ ATAYIN >> accountType (CHECKING-VADESİZ HES,
         * SAVINGS-TASARRUF HES, CREDIT-KREDİ HES) GİBİ...*/

        /** TEKİL BİR HESAP ID'Sİ ATAYIN... HESAP LİSTESİNİN SİZE'INI KULLANARAK SAYAÇ ŞEKLİNDE ID ATANABİLİR...*/

        /** ELDE ETTİĞİNİZ DEĞERLERE GÖRE HESAP LİSTESİNE (accounts) YENİ HESABI EKLEYİNİZ... */

        /** NETİCE OLARAK HESAP EKLEME DURUMUNA GÖRE KULLANICIYA AŞAĞIDAKİ MESAJLARDAN BİRİNİ GÖSTERİN... */
       // System.out.println("Hesap başarıyla açıldı. Hesap Numarası: " + "accountId");
       // System.out.println("Geçersiz seçim! Yeni hesap açma işlemi iptal edildi.");

    }
    ///////////////////////////////////////////////////////////////////////////////////////////


    // PARA EKLE ( deposit() ) METODU  ///////////////////////////////////////////////////////
    public void depositToAccount(Customer customer) throws InterruptedException {
        System.out.println("\n----- PARA YATIR -----");
        System.out.print("Hesap Numarasını Girin(0-önceki sayfa): ");

        do{
        int hesapNo=scanner.nextInt();
            if (hesapNo==0)
                customerOperations(customer);

            boolean a=false;
        for (Account oMusterininAccountu: accounts) {
                if (oMusterininAccountu.getAccountId()==hesapNo && oMusterininAccountu.getCustomerId()==customer.getCustomerId()){
                    System.out.print("Yatırılacak tutarı giriniz: ");
                    double tutar=scanner.nextInt();
                    oMusterininAccountu.depositToAmount(tutar);


                    a=true;
                    customerOperations(customer);
                }
        }
        if(a==false){
            System.out.print("Yanlış hesap no girişi! Tekrar giriniz: ");
        }

        }while(true);



        /** KULLANICIDAN HESAP NUMARASINI ALARAK GEREKLİ KONTROLLERİ GERÇEKLEŞTİRİN
         * YATIRILMAK İSTENEN TUTAR NEGETİF Mİ? POZİTİF Mİ?
         * BU KONTROLÜ, Accounts SINIFINDAN OLUŞTURDUĞUNUZ NESNENİN İÇİNDE depositToAmount(amount) GİBİ
         * BİR METOD TANIMLAYARAK ORADA DA GERÇEKLEŞTİREBİLİRSİNİZ...
         */

        /** accountId VASITASIYLA İSTENEN HESABA ULAŞILABİLİR... */
        /** KULLANICININ GİRDİĞİ HESAP NUMARASI İLGİLİ MÜŞTERİYE AİT Mİ DİYE KONTROL EDİLMELİDİR...*/
        /** KONTROL SONUCUNDA HESAP SINIFI NESNESİNDEN ULAŞTIĞINIZ MÜŞTERİ ID Sİ İLE MÜŞTERİ SINIFININ
         * NESNESİNDEN ULAŞACAĞINIZ MÜŞTERİ ID Sİ AYNI İSE, YATIRILACAK TUTARI KONSOLDA KULLANICIDAN ALIN,
         * VE HESAP SINIFINDAKİ depositToAmount(amount) VASITASIYLA PARAYI YATIRIN...*/

        /** AKSİ HALDE: KULLANICIYA "Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi."
         * MESAJI VERİN...
         */
    }
    ////////////////////////////////////////////////////////////////////////////////////////////


    // PARA ÇEK ( withdraw() ) METODU  /////////////////////////////////////////////////////////
    public void withdrawToAccount(Customer customer) throws InterruptedException {
        System.out.println("\n----- PARA ÇEK -----");
        System.out.print("Hesap Numarasını Girin(0-önceki sayfa): ");
        do{
        int hesapNo=scanner.nextInt();
        if (hesapNo==0)
            customerOperations(customer);
        boolean b=false;
        for (Account account: accounts) {
                if (account.getAccountId()==hesapNo && account.getCustomerId()==customer.getCustomerId()){

                    System.out.print("Çekilecek tutarı giriniz: ");
                    double tutar=scanner.nextInt();
                    account.withdrawToAmount(tutar);


                    b=true;
                    customerOperations(customer);
                }
        }
            if(b==false){
                System.out.print("Yanlış hesap no girişi! Tekrar giriniz: ");
            }
        }while (true);

        /** KULLANICIDAN HESAP NUMARASINI İSTEYEREK PARA ÇEKME İŞLEMİNİ GERÇEKLEŞTİRİN... */
        /** İLGİLİ HESAPTAN PARA ÇEKERKEN, Accounts SINIFINDAKİ withdrawToAmount() METODUNU KULLANIN */
        /** BU METOD VASITASIYLA TUTARIN NEGATİF OLMA DURUMU KONTROL EDİLEBİLİR... */
        /** YİNE BU METOD VASITASIYLA ÇEKİLMEK İSTENEN TUTAR BAKİYEDEN BÜYÜK MÜ DİYE KONTROL EDİLEBİLİR...*/

        /** accountId VASITASIYLA İSTENEN HESABA ULAŞILABİLİR... */
        /** KULLANICININ GİRDİĞİ HESAP NUMARASI İLGİLİ MÜŞTERİYE AİT Mİ DİYE KONTROL EDİLMELİDİR...*/
        /** KONTROL SONUCUNDA HESAP SINIFI NESNESİNDEN ULAŞTIĞINIZ MÜŞTERİ ID Sİ İLE MÜŞTERİ SINIFININ
         * NESNESİNDEN ULAŞACAĞINIZ MÜŞTERİ ID Sİ AYNI İSE, ÇEKİLECEK TUTARI KONSOLDA KULLANICIDAN ALIN,
         * VE HESAP SINIFINDAKİ withDrawToAmount(amount) VASITASIYLA PARAYI ÇEKİN...*/

        /** AKSİ HALDE: KULLANICIYA "Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi."
         * MESAJI VERİN...
         */
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////


    //  BAKİYE SORGULAMA İPUCU METODU ///////////////////////////////////////////////////////////////////
    public void checkBalance(Customer customer) {
        System.out.println("\n----- BAKİYE SORGULA -----");
        System.out.print("Hesap Numarasını Girin: ");
        int accountId = scanner.nextInt();
        scanner.nextLine();

        Account account = getAccountById(accountId);
        if (account != null && account.getCustomerId() == customer.getCustomerId()) {
            System.out.println("Güncel bakiye: " + account.getBalance() + " TL");
        } else {
            System.out.println("Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi.");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////


    // İPUCU METODU ///////////////////////////////////////////////////////////////////////////////////
    // Bu metot, accounts listesinde belirli bir hesabı aramak için kullanılır.
    // Bu sayede, hesap işlemleri sırasında müşteriye ait doğru hesabın bulunması sağlanır.
    // Örneğin, para çekme ve yatırma işlemlerinde, belirli bir müşteriye ait olan hesap bilgilerine
    // doğru bir şekilde ulaşmak için bu metot kullanılır. Girilen accountId (hesap ID) 'sine
    // sahip bir hesap bulunmazsa, metot null değerini döndürür (return null)
    public Account getAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
}
