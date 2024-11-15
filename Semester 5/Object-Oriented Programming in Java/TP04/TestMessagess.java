public class TestMessagess {

    public static void main(String[] args) {
        MessageManager M = new MessageManager();
        Messagess m1 = new Messagess(1, "ms1", "15-10-2023", "C1");
        Messagess m2 = new Messagess(2, "ms2", "16-10-2023", "C2");
        Messagess m3 = new Messagess(3, "ms3", "17-10-2023", "C3");
        Messagess m4 = new Messagess(4, "ms4", "18-10-2023", "C4");

        M.addMessage(m1);
        M.addMessage(m2);
        M.addMessage(m3);
        M.addMessage(m4);

        M.getAllMessages();

        System.out.println("Le nombre total de messages : " + M.getNumberOfMessages());
        System.out.println(M.getFirstMessage());
        System.out.println(M.getLastMessage());
        System.out.println(M.findMessageById(3));
        System.out.println(M.findMessageByTitle("ms4"));

        M.updateMessage(3, "nouveau ms 3", "01-11-2023", "Nv C3");
        M.deleteMessage(2);

        M.getAllMessages();
    }
}
