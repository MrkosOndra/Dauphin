public class Main {
    public static void main(String[] args) {
        WorldMap world= new WorldMap();
        if(world.loadMap()){
            world.printMap();
        }




    }
}