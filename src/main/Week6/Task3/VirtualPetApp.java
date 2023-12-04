package Task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Pet {
    private int x;
    private int y;

    public Pet() {
        this.x = 50;
        this.y = 50;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void updatePosition(int targetX, int targetY, int speedLimit) {
        double angle = Math.atan2(targetY - y, targetX - x);
        int distance = (int) Math.min(speedLimit, Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2)));
        x += (int) (distance * Math.cos(angle));
        y += (int) (distance * Math.sin(angle));
    }
}

class PetCanvas extends JPanel {
    private Pet pet;
    private Image petImage;

    public PetCanvas(Pet pet) {
        this.pet = pet;
        this.petImage = new ImageIcon(getClass().getResource("Cat.png")).getImage();
        setPreferredSize(new Dimension(400, 400));

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                pet.updatePosition(e.getX(), e.getY(), 5);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(petImage, pet.getX(), pet.getY(), this);
    }
}

class PetController {
    private Pet pet;
    private PetCanvas view;

    public PetController(Pet pet, PetCanvas view) {
        this.pet = pet;
        this.view = view;
    }

    public void start() {
        JFrame frame = new JFrame("Virtual Pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

public class VirtualPetApp {
    public static void main(String[] args) {
        Pet pet = new Pet();
        PetCanvas petCanvas = new PetCanvas(pet);
        PetController petController = new PetController(pet, petCanvas);

        SwingUtilities.invokeLater(() -> {
            petController.start();
        });
    }
}
