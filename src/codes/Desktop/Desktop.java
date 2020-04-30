package codes.Desktop;

import javax.swing.table.*;

import codes.Redis.Entity;
import codes.Redis.RedisManager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Apr 29 13:16:38 GMT+08:00 2020
 */


/**
 * @author unknown
 */
public class Desktop extends JFrame {
    public Desktop() {
        initComponents();

    }

    private void testConnectActionPerformed(ActionEvent e) {
        // TODO add your code here
        String host = null;
        Integer port = null;
        String password = null;
        try {
            connect();
            JOptionPane.showMessageDialog(Desktop.this, "连接成功！");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Desktop.this, "连接错误...");
        }

    }

    private void completeActionPerformed(ActionEvent e) {
        // TODO add your code here
        String host = null;
        Integer port = null;
        String password = null;
        try {
            connect();
            redisManager.useDb(0);
            index.setVisible(false);

            dbPage.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Desktop.this, "连接错误...");
        }

    }

    private void connect() {
        String host;
        Integer port;
        String password;
        host = this.host.getText();
        port = Integer.parseInt(this.port.getText());
        password = this.password.getText();
        if (password == null || password.length() <= 0) {
            redisManager = new RedisManager(host, port);
        }
        redisManager = new RedisManager(host, port, password);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        index = new JPanel();
        host = new JTextField();
        labelHost = new JLabel();
        labelPort = new JLabel();
        port = new JTextField();
        labelPassword = new JLabel();
        password = new JTextField();
        testConnect = new JButton();
        complete = new JButton();
        dbPage = new JPanel();
        panelForDbs = new JPanel();
        db_01 = new JButton();
        db_02 = new JButton();
        db_03 = new JButton();
        db_04 = new JButton();
        db_05 = new JButton();
        db_06 = new JButton();
        db_07 = new JButton();
        db_08 = new JButton();
        db_09 = new JButton();
        db_10 = new JButton();
        db_11 = new JButton();
        db_12 = new JButton();
        db_13 = new JButton();
        db_14 = new JButton();
        db_15 = new JButton();
        db_16 = new JButton();
        dataPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        data = new JTable();
        scrollPane2 = new JScrollPane();
        value = new JTextArea();
        keysPanel = new JPanel();
        scrollPane3 = new JScrollPane();
        keysList = new JList<>();
        label1 = new JLabel();
        keysCnt = new JLabel();
        currentDb = new JLabel();
        label4 = new JLabel();

        //======== this ========
        setBackground(Color.black);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== index ========
        {
            index.setBackground(new Color(75, 75, 75));
            index.setVisible(false);
            index.setLayout(null);

            //---- host ----
            host.setText("");
            index.add(host);
            host.setBounds(580, 240, 285, 30);

            //---- labelHost ----
            labelHost.setText("\u5730\u5740\uff1a");
            labelHost.setForeground(new Color(202, 202, 202));
            index.add(labelHost);
            labelHost.setBounds(500, 240, 75, 30);

            //---- labelPort ----
            labelPort.setText("\u7aef\u53e3\uff1a");
            labelPort.setForeground(new Color(202, 202, 202));
            index.add(labelPort);
            labelPort.setBounds(500, 290, 75, 30);

            //---- port ----
            port.setText("6379");
            index.add(port);
            port.setBounds(580, 290, 285, 30);

            //---- labelPassword ----
            labelPassword.setText("\u5bc6\u7801\uff1a");
            labelPassword.setForeground(new Color(202, 202, 202));
            index.add(labelPassword);
            labelPassword.setBounds(500, 340, 75, 30);

            //---- password ----
            password.setText("");
            index.add(password);
            password.setBounds(580, 340, 285, 30);

            //---- testConnect ----
            testConnect.setIcon(new ImageIcon(getClass().getResource("/resources/icons/testConnect.png")));
            testConnect.setBackground(new Color(75, 75, 75));
            testConnect.addActionListener(e -> testConnectActionPerformed(e));
            index.add(testConnect);
            testConnect.setBounds(new Rectangle(new Point(600, 425), testConnect.getPreferredSize()));

            //---- complete ----
            complete.setIcon(new ImageIcon(getClass().getResource("/resources/icons/complete.png")));
            complete.setBackground(new Color(75, 75, 75));
            complete.addActionListener(e -> completeActionPerformed(e));
            index.add(complete);
            complete.setBounds(new Rectangle(new Point(770, 425), complete.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < index.getComponentCount(); i++) {
                    Rectangle bounds = index.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = index.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                index.setMinimumSize(preferredSize);
                index.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(index);
        index.setBounds(0, 0, 1460, 850);

        //======== dbPage ========
        {
            dbPage.setBackground(new Color(75, 75, 75));
            dbPage.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 20));
            dbPage.setForeground(Color.white);
            dbPage.setBorder(null);
            dbPage.setInheritsPopupMenu(true);
            dbPage.setLayout(null);

            //======== panelForDbs ========
            {
                panelForDbs.setBackground(new Color(75, 75, 75));
                panelForDbs.setLayout(null);
                mouseListeners = new MyMouseClickListener[16];

                //---- db_01 ----
                db_01.setText("db_01");
                db_01.setBackground(new Color(75, 75, 75));
                db_01.setForeground(Color.white);
                db_01.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[0] = new Desktop.MyMouseClickListener(db_01);
                panelForDbs.add(db_01);
                db_01.setBounds(20, 20, 242, 45);

                //---- db_02 ----
                db_02.setText("db_02");
                db_02.setBackground(new Color(75, 75, 75));
                db_02.setForeground(Color.white);
                db_02.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[1] = new Desktop.MyMouseClickListener(db_02);
                panelForDbs.add(db_02);
                db_02.setBounds(20, 70, 242, 45);

                //---- db_03 ----
                db_03.setText("db_03");
                db_03.setBackground(new Color(75, 75, 75));
                db_03.setForeground(Color.white);
                db_03.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[2] = new Desktop.MyMouseClickListener(db_03);
                panelForDbs.add(db_03);
                db_03.setBounds(20, 120, 242, 45);

                //---- db_04 ----
                db_04.setText("db_04");
                db_04.setBackground(new Color(75, 75, 75));
                db_04.setForeground(Color.white);
                db_04.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[3] = new Desktop.MyMouseClickListener(db_04);
                panelForDbs.add(db_04);
                db_04.setBounds(20, 170, 242, 45);

                //---- db_05 ----
                db_05.setText("db_05");
                db_05.setBackground(new Color(75, 75, 75));
                db_05.setForeground(Color.white);
                db_05.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[4] = new Desktop.MyMouseClickListener(db_05);
                panelForDbs.add(db_05);
                db_05.setBounds(20, 220, 242, 45);

                //---- db_06 ----
                db_06.setText("db_06");
                db_06.setBackground(new Color(75, 75, 75));
                db_06.setForeground(Color.white);
                db_06.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[5] = new Desktop.MyMouseClickListener(db_06);
                panelForDbs.add(db_06);
                db_06.setBounds(20, 270, 242, 45);

                //---- db_07 ----
                db_07.setText("db_07");
                db_07.setBackground(new Color(75, 75, 75));
                db_07.setForeground(Color.white);
                db_07.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[6] = new Desktop.MyMouseClickListener(db_07);
                panelForDbs.add(db_07);
                db_07.setBounds(20, 320, 242, 45);

                //---- db_08 ----
                db_08.setText("db_08");
                db_08.setBackground(new Color(75, 75, 75));
                db_08.setForeground(Color.white);
                db_08.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[7] = new Desktop.MyMouseClickListener(db_08);
                panelForDbs.add(db_08);
                db_08.setBounds(20, 370, 242, 45);

                //---- db_09 ----
                db_09.setText("db_09");
                db_09.setBackground(new Color(75, 75, 75));
                db_09.setForeground(Color.white);
                db_09.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[8] = new Desktop.MyMouseClickListener(db_09);
                panelForDbs.add(db_09);
                db_09.setBounds(20, 420, 242, 45);

                //---- db_10 ----
                db_10.setText("db_10");
                db_10.setBackground(new Color(75, 75, 75));
                db_10.setForeground(Color.white);
                db_10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[9] = new Desktop.MyMouseClickListener(db_10);
                panelForDbs.add(db_10);
                db_10.setBounds(20, 470, 242, 45);

                //---- db_11 ----
                db_11.setText("db_11");
                db_11.setBackground(new Color(75, 75, 75));
                db_11.setForeground(Color.white);
                db_11.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[10] = new Desktop.MyMouseClickListener(db_11);
                panelForDbs.add(db_11);
                db_11.setBounds(20, 520, 242, 45);

                //---- db_12 ----
                db_12.setText("db_12");
                db_12.setBackground(new Color(75, 75, 75));
                db_12.setForeground(Color.white);
                db_12.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[11] = new Desktop.MyMouseClickListener(db_12);
                panelForDbs.add(db_12);
                db_12.setBounds(20, 570, 242, 45);

                //---- db_13 ----
                db_13.setText("db_13");
                db_13.setBackground(new Color(75, 75, 75));
                db_13.setForeground(Color.white);
                db_13.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[12] = new Desktop.MyMouseClickListener(db_13);
                panelForDbs.add(db_13);
                db_13.setBounds(20, 620, 242, 45);

                //---- db_14 ----
                db_14.setText("db_14");
                db_14.setBackground(new Color(75, 75, 75));
                db_14.setForeground(Color.white);
                db_14.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[13] = new Desktop.MyMouseClickListener(db_14);
                panelForDbs.add(db_14);
                db_14.setBounds(20, 670, 242, 45);

                //---- db_15 ----
                db_15.setText("db_15");
                db_15.setBackground(new Color(75, 75, 75));
                db_15.setForeground(Color.white);
                db_15.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[14] = new Desktop.MyMouseClickListener(db_15);
                panelForDbs.add(db_15);
                db_15.setBounds(20, 720, 242, 45);

                //---- db_16 ----
                db_16.setText("db_16");
                db_16.setBackground(new Color(75, 75, 75));
                db_16.setForeground(Color.white);
                db_16.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
                mouseListeners[15] = new Desktop.MyMouseClickListener(db_16);
                panelForDbs.add(db_16);
                db_16.setBounds(20, 770, 242, 45);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < panelForDbs.getComponentCount(); i++) {
                        Rectangle bounds = panelForDbs.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panelForDbs.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panelForDbs.setMinimumSize(preferredSize);
                    panelForDbs.setPreferredSize(preferredSize);
                }
            }
            dbPage.add(panelForDbs);
            panelForDbs.setBounds(15, 15, 280, 830);

            //======== dataPanel ========
            {
                dataPanel.setBackground(new Color(75, 75, 75));
                dataPanel.setLayout(null);

                //======== scrollPane1 ========
                {

                    //---- data ----
                    createNewTableModel(null, null, null);
                    data.setFont(new Font("\u534e\u6587\u4e2d\u5b8b", Font.BOLD, 18));
                    data.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                    data.setEnabled(false);
                    data.setRowHeight(35);
                    data.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    data.setBackground(new Color(75, 75, 75));
                    data.setForeground(Color.white);
                    data.setFillsViewportHeight(true);
                    data.setRowSelectionAllowed(false);
                    scrollPane1.setViewportView(data);
                }
                dataPanel.add(scrollPane1);
                scrollPane1.setBounds(15, 10, 740, 130);

                //======== scrollPane2 ========
                {

                    //---- value ----
                    value.setEditable(false);
//                    value.setEnabled(false);
                    value.setLineWrap(true);
                    value.setBackground(new Color(75, 75, 75));
                    value.setForeground(Color.white);
                    pairValue = "null";
                    value.setText(pairValue);
                    value.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 18));
                    scrollPane2.setViewportView(value);
                }
                dataPanel.add(scrollPane2);
                scrollPane2.setBounds(15, 160, 740, 645);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < dataPanel.getComponentCount(); i++) {
                        Rectangle bounds = dataPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = dataPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    dataPanel.setMinimumSize(preferredSize);
                    dataPanel.setPreferredSize(preferredSize);
                }
            }
            dbPage.add(dataPanel);
            dataPanel.setBounds(665, 10, 780, 825);

            //======== keysPanel ========
            {
                keysPanel.setBorder(null);
                keysPanel.setBackground(new Color(75, 75, 75));
                keysPanel.setForeground(Color.white);
                keysPanel.setLayout(null);

                //======== scrollPane3 ========
                {

                    //---- keysList ----
                    keysListModel = new DefaultListModel<>();
                    currentKeys = new ArrayList<String>();
                    keysList.setModel(keysListModel);
                    keysList.setBackground(new Color(75, 75, 75));
                    keysList.setForeground(Color.white);
                    keysList.setSelectionBackground(new Color(203, 203, 203));
                    Desktop.MyMouseClickListener mouseDoubleClickListener = new Desktop.MyMouseClickListener(keysList);
                    keysList.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                    scrollPane3.setViewportView(keysList);
                }
                keysPanel.add(scrollPane3);
                scrollPane3.setBounds(10, 55, 310, 765);

                //---- label1 ----
                label1.setText("\u5f53\u524d\uff1a");
                label1.setBackground(new Color(75, 75, 75));
                label1.setForeground(Color.white);
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                keysPanel.add(label1);
                label1.setBounds(15, 5, 50, 45);

                //---- keysCnt ----
                keysCnt.setText("");
                keysCnt.setBackground(new Color(75, 75, 75));
                keysCnt.setForeground(Color.white);
                keysCnt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                keysPanel.add(keysCnt);
                keysCnt.setBounds(200, 5, 120, 45);

                //---- currentDb ----
                currentDb.setText("");
                currentDb.setBackground(new Color(75, 75, 75));
                currentDb.setForeground(Color.white);
                currentDb.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                keysPanel.add(currentDb);
                currentDb.setBounds(70, 5, 60, 45);

                //---- label4 ----
                label4.setText("\u952e\u6570\uff1a");
                label4.setBackground(new Color(75, 75, 75));
                label4.setForeground(Color.white);
                label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                keysPanel.add(label4);
                label4.setBounds(135, 5, 65, 45);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < keysPanel.getComponentCount(); i++) {
                        Rectangle bounds = keysPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = keysPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    keysPanel.setMinimumSize(preferredSize);
                    keysPanel.setPreferredSize(preferredSize);
                }
            }
            dbPage.add(keysPanel);
            keysPanel.setBounds(315, 15, 330, 830);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < dbPage.getComponentCount(); i++) {
                    Rectangle bounds = dbPage.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dbPage.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dbPage.setMinimumSize(preferredSize);
                dbPage.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(dbPage);
        dbPage.setBounds(0, 0, 1460, 850);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        {
            //popMenu,一次创建，避免资源浪费
            popupMenu = new JPopupMenu();
            refresh = new JMenuItem("刷新");
            insert = new JMenuItem("新增");
            flushAll = new JMenuItem("清空");
            refresh.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            insert.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            flushAll.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            PopMenuChildClickListener refreshListener = new PopMenuChildClickListener(refresh);
            PopMenuChildClickListener insertListener = new PopMenuChildClickListener(insert);
            PopMenuChildClickListener flushAllListener = new PopMenuChildClickListener(flushAll);
            popupMenu.add(refresh);
            popupMenu.add(insert);
            popupMenu.add(flushAll);
            popupMenu.setSize(150, 120);

        }
        setSize(1480, 900);
        this.setResizable(false);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        dbPage.setVisible(false);
        index.setVisible(true);
        this.setTitle("My Redis Management Tool (Non-commercial)");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //设置新的表格数据Model
    private void createNewTableModel(String key, String value, String ttl) {
        tableModel = new DefaultTableModel(
                new Object[][]{
                        {"key:", key},
                        {"value:", value},
                        {"ttl:", ttl},
                },
                new String[]{
                        null, null
                }
        );
        data.setModel(tableModel);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel index;
    private JTextField host;
    private JLabel labelHost;
    private JLabel labelPort;
    private JTextField port;
    private JLabel labelPassword;
    private JTextField password;
    private JButton testConnect;
    private JButton complete;
    private JPanel dbPage;
    private JPanel panelForDbs;
    private JButton db_01;
    private JButton db_02;
    private JButton db_03;
    private JButton db_04;
    private JButton db_05;
    private JButton db_06;
    private JButton db_07;
    private JButton db_08;
    private JButton db_09;
    private JButton db_10;
    private JButton db_11;
    private JButton db_12;
    private JButton db_13;
    private JButton db_14;
    private JButton db_15;
    private JButton db_16;
    private JPanel dataPanel;
    private JScrollPane scrollPane1;
    private JTable data;
    private JScrollPane scrollPane2;
    private JTextArea value;
    private JPanel keysPanel;
    private JScrollPane scrollPane3;
    private JList<String> keysList;
    private JLabel label1;
    private JLabel keysCnt;
    private JLabel currentDb;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private RedisManager redisManager;
    private ArrayList<String> currentKeys;
    private DefaultListModel<String> keysListModel;
    private DefaultTableModel tableModel;
    private String pairValue;
    private MyMouseClickListener[] mouseListeners;
    private JPopupMenu popupMenu;
    private JMenuItem refresh, insert, flushAll;

    //鼠标监听
    class MyMouseClickListener implements MouseListener {
        private Component component;

        public MyMouseClickListener(Component component) {
            this.component = component;
            component.addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            //双击事件
            if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                try {
                    /*DB菜单双击事件*/
                    if (component instanceof JButton) {
                        String db = ((JButton) component).getText();

                        int dbIndex = Integer.parseInt(db.substring(3));
                        redisManager.useDb(dbIndex - 1);
                        getAllKeysFromDB();

                        currentDb.setText(db);
                        createNewTableModel(null, null, null);
                        value.setText("null");
                    }
                    /*键值列表项双击事件*/
                    else if (component instanceof JList) {
                        JList jList = (JList) component;
                        int keyIndex = jList.getSelectedIndex();
                        if (keyIndex >= 0) {
                            Entity entity = redisManager.select(currentKeys.get(keyIndex));

                            createNewTableModel(entity.getKey(), entity.getValue().toString(), String.valueOf(entity.getTtl()));
                            pairValue = entity.getValue().toString();
                            value.setText(entity.toString());
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    createAutoCloseDialog("连接错误...");
                }

            }
            /*DB菜单右键弹出菜单事件*/
            else if (e.getButton() == MouseEvent.BUTTON3 && component instanceof JButton && ((JButton) component).getText().equalsIgnoreCase(currentDb.getText())) {
                popupMenu.show(e.getComponent(), e.getComponent().getX() + e.getComponent().getWidth() - 20, (e.getComponent().getX()));
            }
            /*键值列表项右键事件*/
            else if (e.getButton() == MouseEvent.BUTTON3 && component instanceof JList) {
                try {
                    JList jList = (JList) component;
                    int keyIndex = jList.getSelectedIndex();
                    if (keyIndex >= 0) {
                        int i = JOptionPane.showConfirmDialog(Desktop.this, "确定要删除这个键吗？");
                        if (i == JOptionPane.YES_NO_OPTION) {
                            redisManager.delete(currentKeys.get(keyIndex));
                            getAllKeysFromDB();
                        }
                    }
                } catch (Exception ex) {
                    createAutoCloseDialog("连接错误...");
                }

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    //获取当前DB的所有键值
    private void getAllKeysFromDB() {
        try {
            if (currentKeys != null) {
                //循环移除，避免线程问题，带来一定效率问题
                for (String key : currentKeys) {
                    keysListModel.removeElement(key);
                }
            }
            Set<String> allKeys = redisManager.selectAllKeys();
            currentKeys = new ArrayList<>();
            //循环加入
            for (String key : allKeys) {
                currentKeys.add(key);
                keysListModel.addElement(key);
            }

            keysCnt.setText(currentKeys.size() + "");
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(Desktop.this, "连接错误...");
            createAutoCloseDialog("数据异常，请重试！");
        }

    }

    //弹出菜单监听器
    class PopMenuChildClickListener implements ActionListener {
        private JMenuItem component;

        public PopMenuChildClickListener(JMenuItem component) {
            this.component = component;
            component.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            /*刷新事件*/
            if (component.getText().equalsIgnoreCase("刷新")) {
                getAllKeysFromDB();
            }
            /*新增事件*/
            else if (component.getText().equalsIgnoreCase("新增")) {
                createMenuDialog();
            }
            /*清空事件*/
            else if (component.getText().equalsIgnoreCase("清空")) {
                try {
                    int confirmDialog = JOptionPane.showConfirmDialog(Desktop.this, "确定要清空数据库吗？");
                    if (confirmDialog == JOptionPane.YES_NO_OPTION) {
                        redisManager.flushDB();
                        getAllKeysFromDB();
                    }
                } catch (Exception ex) {
                    createAutoCloseDialog("数据异常，请重试");
//                    JOptionPane.showMessageDialog(Desktop.this, "连接错误...");
                }
            }
        }
    }

    //创建新增键值对弹窗
    private void createMenuDialog() {
        JDialog dialog = new JDialog(Desktop.this, "新增", true);
        dialog.setSize(450, 350);
        dialog.setResizable(false);
        int x = Desktop.this.getX() / 2 + Desktop.this.getWidth() / 2 - dialog.getWidth() / 2;
        int y = Desktop.this.getY() / 2 + Desktop.this.getHeight() / 2 - dialog.getHeight() / 2;
        dialog.setLocation(x, y);
        JTextField key = new JTextField();
        JTextField value = new JTextField();
        JButton confirm = new JButton();
        JButton cancel = new JButton();
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String keyStr = key.getText();
                    String valueStr = value.getText();
                    if (keyStr == null || keyStr.length() <= 0 || valueStr == null || valueStr.length() <= 0) {
                        JOptionPane.showMessageDialog(Desktop.this, "请将数据填写完整！");
                        return;
                    }
                    int confirmDialog = JOptionPane.showConfirmDialog(Desktop.this, "确定要保存吗？");
                    if (confirmDialog == JOptionPane.YES_NO_OPTION) {
                        String insert = redisManager.insert(keyStr, valueStr);
//                            System.out.println(insert);
                        if (insert.equalsIgnoreCase("ok")) {
                            dialog.dispose();
                            createAutoCloseDialog("保存成功");
//                            JOptionPane.showMessageDialog(Desktop.this, "连接错误...");
                            getAllKeysFromDB();
                        } else {
                            createAutoCloseDialog("保存失败，请稍后重试...");
//                            JOptionPane.showMessageDialog(Desktop.this, "");
                        }

                    }
                } catch (Exception ex) {
                    createAutoCloseDialog("连接中...");
//                    JOptionPane.showMessageDialog(Desktop.this, "数据异常，请重试");
                }
            }
        });
        confirm.setIcon(new ImageIcon(getClass().getResource("/resources/icons/upload.png")));
        cancel.setIcon(new ImageIcon(getClass().getResource("/resources/icons/uploadCancel.png")));
        cancel.setBackground(new Color(75, 75, 75));
        confirm.setBackground(new Color(75, 75, 75));
        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(75, 75, 75));
        jPanel.setSize(250, 150);
        jPanel.setLayout(null);
        key.setBounds(40, 60, 180, 50);
        key.setText("key");
        jPanel.add(key);
        jPanel.add(value);
        value.setBounds(250, 60, 180, 50);
        value.setText("value");
        jPanel.add(confirm);
        confirm.setBounds(100, 200, 80, 40);
        jPanel.add(cancel);
        cancel.setBounds(250, 200, 80, 40);
        dialog.setContentPane(jPanel);
        dialog.setVisible(true);
    }

    //创建自动关闭的弹窗
    private void createAutoCloseDialog(String message) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("异常");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dialog.setVisible(false);
                dialog.dispose();
            }
        }, 1000);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setAlwaysOnTop(true);
        dialog.setModal(false);
        dialog.setVisible(true);
    }
}
