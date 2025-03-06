public class Help extends Command{
    public Help(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        System.out.println("dostupne prikazy:" +
                "move <misto> : pohnes se do mista kam chces (pokud tam vede cesta)");
        System.out.println("Exit : Hra se ukonci");
        System.out.println("Talk<NPCName>: zacnes mluvit s danou postavou");
        System.out.println("Take: Seberes item po dokonceni ukolu");
        System.out.println("Complete: dokoncis ukol");


    }

    @Override
    public boolean exit() {
        return false;
    }
}
