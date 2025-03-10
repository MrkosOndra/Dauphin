public class Talk extends Command {
    public Talk(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("pouziti: Talk <NPC_name>");
            return;
        }
        String NpcName = args[1].toLowerCase();
        NPC npc = map.getCurrentLocation().getNPC(NpcName);
        if (npc != null) {
            npc.talk();
            Task task = npc.giveTask();
            if (task != null) {
                System.out.println("Úkol: " + task.getDescription());
            } else {
                System.out.println("Zde nikdo se jmenem" + npc.getName() + "neni!!");
            }
        }

        }

    @Override
    public boolean exit() {
        return false;
    }
}
