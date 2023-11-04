public class Colisiones {
    private Player player;
    private Bloques bloques;

    public Colisiones(Player player, Bloques bloques) {
        this.player = player;
        this.bloques = bloques;
    }

    public void verificarColisiones() {
        // Colisiones con pared izquierda
        if (player.getX() < 0) {
            player.setX(0);
            
            
        }

        // Colisiones con pared derecha
        int limiteDerecho = bloques.getNumBlocks() * bloques.getBlockSize() - player.getWidth();
        if (player.getX() > limiteDerecho) {
            player.setX(limiteDerecho);
            //System.out.println("¡Aca!");
        }
    }
    
    
    
}
