import java.util.Scanner;

public class Account{

    // FIELDS   /////////////////////////////////////////////////////////////
    private int accountId;
    private int customerId;
    private double balance;
    private AccountType accountType;
    /////////////////////////////////////////////////////////////////////////


    // CONSTRUCTORS /////////////////////////////////////////////////////////
    public Account() {
    }

    public Account(int accountId, int customerId, AccountType accountType) {
        setAccountId(accountId);
        setCustomerId(customerId);
        setAccountType(accountType);
    }
    /////////////////////////////////////////////////////////////////////////

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }


    // GETTER AND SETTER METHODS    /////////////////////////////////////////
    /** GETTER VE SETTER METODLARINI OLUŞTURUN */

    ////////////////////////////////////////////////////////////////////////////


    // PARA EKLE (DEPOSIT) METODU   ////////////////////////////////////////////
    // YATIRILACAK TUTARIN SIFIRDAN BÜYÜK OLMASI GEREKİR.
    // ŞART SAĞLANDIĞINDA İLGİLİ HESABIN BAKİYESİ ARTMIŞ OLMALIDIR.
    public void depositToAmount(double amount) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        do{
        if(amount>0){
            balance+=amount;

            System.out.print(" Para yatırılıyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }

            System.out.println("\n"+amount+" yatırıldı...");
            System.out.println("Güncel bakiye: "+balance);break;

        }else {
            System.out.print("0'dan büyük değer giriniz: ");
            amount=scanner.nextInt();
        }}while(true);
        /** BU METODU BankSimulation SINIFINDAKİ depositToAccount() METODUNDA DİREKT ÇAĞIRARAK KULLANIN*/
        /** YATIRILMAK İSTENEN TUTAR, SIFIRDAN BÜYÜK MÜ DEĞİL Mİ KONTROL EDİN*/
        /** BÜYÜKSE BAKİYEYE İLAVE EDİP KULLANICIYA MESAJ VERİN*/
        /** YATIRILMAK İSTENEN TUTAR SIFIRDAN KÜÇÜKSE KULLANICIYA MESAJ VERİN, YENİDEN DENEMESİNİ İSTEYİN...*/
    }
    ////////////////////////////////////////////////////////////////////////////////////////


    // PARA ÇEK (WITHDRAW) METODU   ///////////////////////////////////////////////////////
    // ÇEKİLECEK TUTARIN SIFIRDAN BÜYÜK OLMASI GEREKİR.
    // ŞART SAĞLANDIĞINDA İLGİLİ HESABIN BAKİYESİ TUTAR KADAR AZALMIŞ OLMALIDIR.
    public void withdrawToAmount(double amount) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        do{
            if(balance==0){
                System.out.println("Bakiyeniz 0 TL...");
                break;
            }
            if(amount>balance || amount<=0 ){
                System.out.print("0'dan büyük ve bakiyeden küçük değer giriniz: ");
                break;
            }else if(amount>0 && balance>amount && balance>0) {
                balance-=amount;
            }

                System.out.print(" Para çekiliyor...");
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(100);
                    System.out.print(">");
                }

                System.out.println("\n"+amount+" çekildi...");
                System.out.println("Güncel bakiye: "+balance);break;

            }while(true);

        /** BU METODU BankSimulation SINIFINDAKİ withdrawToAccount() METODUNDA DİREKT ÇAĞIRARAK KULLANIN*/
        /** ÇEKİLMEK İSTENEN TUTAR, NEGATİF Mİ, DEĞİL Mİ KONTROL EDİN*/
        /** ÇEKİLMEK İSTENEN TUTAR BAKİYEDEN BÜYÜK MÜ, DEĞİL Mİ KONTROL EDİN    */
        /** ÇEKİLMEK İSTENEN TUTAR (amount) POZİTİFSE VE BAKİYEDEN KÜÇÜKSE, BAKİYEDEN DÜŞÜP,
         * YENİ BAKİYEYİ KULLANICIYA BİLDİRİN... */
        /** YATIRILMAK İSTENEN TUTAR SIFIRDAN KÜÇÜKSE YA DA BAKİYEDEN BÜYÜKSE,
         * KULLANICIYA MESAJ VERİN, YENİDEN DENEMESİNİ İSTEYİN...*/
    }
    /////////////////////////////////////////////////////////////////////////////////////


    // TO STRING METODU ////////////////////////////////////////////////////////////////////
    /** TO STRING METODUNU OLUŞTURUN... */
    ////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public String toString() {
        return "Account" +
                "accountId=" + accountId +
                ", customerId=" + customerId +
                ", balance=" + balance +
                ", accountType=" + accountType;
    }
}
