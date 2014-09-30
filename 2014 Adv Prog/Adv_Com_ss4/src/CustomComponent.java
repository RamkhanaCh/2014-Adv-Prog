import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Graphics;

    import javax.swing.JComponent;

    @SuppressWarnings("serial")
    public class CustomComponent extends JComponent {

        @Override
        public Dimension getMinimumSize() {
            return new Dimension(100, 100);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 200);
        }

        @Override
        public void paintComponent(Graphics g) {
            int margin = 100;
            Dimension dim = getSize();
            super.paintComponent(g);
            g.setColor(Color.orange);
            g.drawString("Custom Component",180,200);
            g.fillRect(margin, margin, dim.width-margin*2, dim.height-margin*2);
        }

    }