package Command;

import World.NPC;
import World.Task;
import World.WorldMap;

public class Complete extends Command {
    public Complete(WorldMap map) {
        super(map);
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Použití: complete <jméno_npc>");
            return;
        }

        String npcName = args[1];
        NPC npc = map.getCurrentLocation().getNPC(npcName);

        if (npc == null) {
            System.out.println("Tento World.NPC zde není.");
            return;
        }

        Task task = npc.giveTask();

        if (task == null) {
            System.out.println("Tento World.NPC nemá žádný úkol.");
            return;
        }

        if (map.getPlayer().hasItem(task.getRequiredItem().getName())) {
            map.getPlayer().addItem(task.getReward());
            npc.getTasks().remove(task);
            System.out.println("Úkol splněn! Dostal jsi: " + task.getReward().getName());
        } else {
            System.out.println("Nemáš potřebný předmět k dokončení úkolu.");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
