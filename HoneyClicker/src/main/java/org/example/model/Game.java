package org.example.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class Game {

    private static final Game game = new Game();

    private static volatile float honeyCount;

    private Bee bees;
    private BeeHive hives;
    private Farm farms;
    private Factory factories;
    private Bank banks;

    private final int width = 1200;
    private final int height = 900;

    private Font captionFont, buttonFont, descriptionFont;

    private static JFrame window;
    private static JLabel counterLabel, clockLabel;
    private JTextArea description;
    private JButton buttonBee, buttonHive, buttonFarm, buttonFactory, buttonBank;

    private ClickHandler clickHandler = new ClickHandler();
    private MouseHandler mouseHandler = new MouseHandler();

    private static GlobalClock clock;

    private Game(){

        captionFont = new Font("Comic Sans MS", Font.BOLD, 32);
        buttonFont = new Font("Comic Sans MS", Font.PLAIN, 30);
        descriptionFont = new Font("Comic Sans MS", Font.ITALIC, 28);

        clock = GlobalClock.getInstance();

        bees = new Bee();
        hives = new BeeHive();
        farms = new Farm();
        factories = new Factory();
        banks = new Bank();

        honeyCount = 0;
        generateUI();

    }

    public static Game getInstance(){
        return game;
    }

    private void generateUI(){

        window = new JFrame();
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.DARK_GRAY);
        window.setLayout(null);

        JPanel flowerPanel = new JPanel();
        flowerPanel.setBounds(width/3, 200, 444, 425);
        flowerPanel.setOpaque(false);
        window.add(flowerPanel);

        ImageIcon flowerIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameResources/flower.png")));

        JButton flowerButton = new JButton();
        flowerButton.setOpaque(false);
        flowerButton.setFocusPainted(false);
        flowerButton.setBorder(null);
        flowerButton.setIcon(flowerIcon);
        flowerButton.setContentAreaFilled(false);
        flowerButton.addActionListener(clickHandler);
        flowerButton.setActionCommand("flower click");
        flowerPanel.add(flowerButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100, 50, width-200, 100);
        counterPanel.setBackground(Color.YELLOW);
        counterPanel.setLayout(new GridLayout(1,1));
        window.add(counterPanel);

        counterLabel = new JLabel("Accumulated Honey: " + String.format("%.0f", honeyCount), SwingConstants.CENTER);
        counterLabel.setForeground(Color.black);
        counterLabel.setFont(captionFont);
        counterLabel.setBorder(BorderFactory.createLineBorder(Color.black,4));
        counterPanel.add(counterLabel);

        JPanel itemPanel = new JPanel();
        itemPanel.setBounds(width - 300, 200, 250, 500);
        itemPanel.setBackground(Color.black);
        itemPanel.setLayout(new GridLayout(5, 1));
        window.add(itemPanel);

        buttonBee = new JButton("Bee  " + bees.getCount() + "/" + bees.getCapacity());
        buttonBee.setFont(buttonFont);
        buttonBee.setFocusPainted(false);
        buttonBee.addActionListener(clickHandler);
        buttonBee.addMouseListener(mouseHandler);
        buttonBee.setActionCommand("Bee");
        itemPanel.add(buttonBee);

        buttonHive = new JButton("Beehive  " + hives.getCount() + "/" + hives.getCapacity());
        buttonHive.setFont(buttonFont);
        buttonHive.setFocusPainted(false);
        buttonHive.addActionListener(clickHandler);
        buttonHive.addMouseListener(mouseHandler);
        buttonHive.setActionCommand("Beehive");
        itemPanel.add(buttonHive);

        buttonFarm = new JButton("Farm  " + farms.getCount() + "/" + farms.getCapacity());
        buttonFarm.setFont(buttonFont);
        buttonFarm.setFocusPainted(false);
        buttonFarm.addActionListener(clickHandler);
        buttonFarm.addMouseListener(mouseHandler);
        buttonFarm.setActionCommand("Farm");
        itemPanel.add(buttonFarm);

        buttonFactory = new JButton("Factory  " + factories.getCount() + "/" + factories.getCapacity());
        buttonFactory.setFont(buttonFont);
        buttonFactory.setFocusPainted(false);
        buttonFactory.addActionListener(clickHandler);
        buttonFactory.addMouseListener(mouseHandler);
        buttonFactory.setActionCommand("Factory");
        itemPanel.add(buttonFactory);

        buttonBank = new JButton("Bank  " + banks.getCount() + "/" + banks.getCapacity());
        buttonBank.setFont(buttonFont);
        buttonBank.setFocusPainted(false);
        buttonBank.addActionListener(clickHandler);
        buttonBank.addMouseListener(mouseHandler);
        buttonBank.setActionCommand("Bank");
        itemPanel.add(buttonBank);

        description = new JTextArea();
        description.setBounds(50, 200, 300, 500);
        description.setForeground(Color.black);
        description.setBackground(Color.orange);
        description.setFont(descriptionFont);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEditable(false);
        description.setBorder(BorderFactory.createLineBorder(Color.black,4));
        description.setText("Click the flower to gain honey!");
        window.add(description);

        JPanel clockPanel = new JPanel();
        clockPanel.setBounds(100, 725, 200, 75);
        clockPanel.setBackground(Color.orange);
        clockPanel.setLayout(new GridLayout(1,1));
        window.add(clockPanel);

        clockLabel = new JLabel(String.format( clock.getHours() + " : 00"), SwingConstants.CENTER);
        clockLabel.setForeground(Color.black);
        clockLabel.setFont(captionFont);
        clockLabel.setBorder(BorderFactory.createLineBorder(Color.black,4));
        clockPanel.add(clockLabel);


        ImageIcon splatterIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameResources/honeySplatter.png")));

        JLabel splatter = new JLabel(splatterIcon);
        splatter.setBounds(160, -20, 924, 900);
        window.add(splatter);

        window.setVisible(true);

    }

    public static void increaseHoney(float amount){

        honeyCount += amount;
        counterLabel.setText("Accumulated Honey: " + String.format("%.0f", honeyCount));

    }

    public static void advanceTime(){

        clockLabel.setText(String.format( clock.getHours() + " : 00"));

        if(GlobalClock.daytime()) {
            window.getContentPane().setBackground(Color.CYAN);
        }
        else{
            window.getContentPane().setBackground(Color.DARK_GRAY);
        }
    }

    private class ClickHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String type = e.getActionCommand();

            switch (type) {
                case "flower click":
                    Game.increaseHoney(10);
                    break;
                case "Bee":
                    bees.buyItem(honeyCount);
                    buttonBee.setText("Bee  " + bees.getCount() + "/" + bees.getCapacity());
                    break;
                case "Beehive":
                    hives.buyItem(honeyCount);
                    buttonHive.setText("Beehive  " + hives.getCount() + "/" + hives.getCapacity());
                    break;
                case "Farm":
                    farms.buyItem(honeyCount);
                    buttonFarm.setText("Farm  " + farms.getCount() + "/" + farms.getCapacity());
                    break;
                case "Factory":
                    factories.buyItem(honeyCount);
                    buttonFactory.setText("Factory  " + factories.getCount() + "/" + factories.getCapacity());
                    break;
                case "Bank":
                    banks.buyItem(honeyCount);
                    buttonBank.setText("Bank  " + banks.getCount() + "/" + banks.getCapacity());
                    break;

            }

        }

    }

    private class MouseHandler implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

            JButton button = (JButton) e.getSource();

            if (button == buttonBee) {
                description.setText(bees.getDescription());
            } else if (button == buttonHive) {
                description.setText(hives.getDescription());
            } else if (button == buttonFarm) {
                description.setText(farms.getDescription());
            } else if (button == buttonFactory) {
                description.setText(factories.getDescription());
            } else if(button == buttonBank){
                description.setText(banks.getDescription());
            }

        }

        @Override
        public void mouseExited(MouseEvent e) {

            description.setText("Click the flower to gain honey!");

        }

    }

}
