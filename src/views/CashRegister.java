/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.toedter.calendar.JDateChooser;
import controller.ColorController;
import controller.CustomerController;
import controller.ItemController;
import controller.TicketController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import model.Ticket;
import programa.Globales;

/**
 *
 * @author JORGE MANCERA
 */
public class CashRegister extends javax.swing.JFrame {

    /**
     * Creates new form CashRegister
     */
    private String date1, date2, item;
    private String cliente;
    private Object[] datos = new Object[9];
    private int cantidad, numItems;
    private double importe, total, precio, accumTotal;
    private int index;
    private int idCliente;
    int color;

    private double price, amount, change, payment;
    private int quantity, folio, stock, idUser, rows;

    Ticket ticket = new Ticket();
    TicketController cticket = new TicketController();
    ItemController citem = new ItemController();

    public CashRegister() {
        initComponents();
        this.getContentPane().setBackground(new java.awt.Color(188, 200, 214, 255));
        date1 = "";
        date2 = "";

        ColorController colours = new ColorController();
        ArrayList<String> listColor = colours.all();
        // jcbColor = new JComboBox<>();

        DefaultComboBoxModel<String> modelColor = new DefaultComboBoxModel<>();
        modelColor.addElement("Elige un color");

        /*     listColor.forEach((s) -> {
        //     modelColor.addElement(s);
             System.out.println(s);
             jcbColor.addItem(s);
        });*/
        for (int i = 0; i < listColor.size(); i++) {
            modelColor.addElement(listColor.get(i));
        }

        jcbColor.setModel(modelColor);

        txFolio.setText("" + cticket.getFolio());
        txFolio.setEditable(false);
        
        tableRegister.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableRegister.setRowHeight(25);
        tableRegister.setShowVerticalLines(false);
        tableRegister.getTableHeader().setReorderingAllowed(false);
        tableRegister.setSelectionBackground(new java.awt.Color(52, 152, 219));
        tableRegister.setFont(new java.awt.Font("Verdana", 0, 16));
        tableRegister.getTableHeader().setFont(new java.awt.Font("Verdana", Font.PLAIN, 16));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegister = new javax.swing.JTable();
        btSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txFolio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbFecha_entrada = new javax.swing.JLabel();
        jdFirstDate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jdEndDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txQuantity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbCustomer = new javax.swing.JComboBox<>();
        txCustomer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbDescription = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jcbColor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txPrice = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        txItem = new javax.swing.JTextField();
        btClear = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbitems = new javax.swing.JLabel();
        lbTotalItems = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TINTORERIA YIMI");
        setResizable(false);

        tableRegister.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Articulo", "Descripcion", "Color", "id_color", "Precio", "Fecha Entrada", "Fecha Salida", "Importe"
            }
        ));
        tableRegister.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableRegisterKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableRegister);

        btSave.setBackground(new java.awt.Color(36, 83, 148));
        btSave.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 255, 255));
        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/floppydisk_2.png"))); // NOI18N
        btSave.setText("Guardar");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FOLIO: ");

        txFolio.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Edit");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(217, 225, 230));

        lbFecha_entrada.setText("Fecha entrada: ");

        jLabel8.setText("Fecha Entrega: ");

        jLabel4.setText("Cantidad: ");

        txQuantity.setText("1");
        txQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txQuantityKeyReleased(evt);
            }
        });

        jLabel3.setText("Cliente: ");

        jcbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Cliente", "MOSTRADOR", "Otro..." }));
        jcbCustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCustomerItemStateChanged(evt);
            }
        });
        jcbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCustomerActionPerformed(evt);
            }
        });

        jLabel5.setText("Descripcion: ");

        jcbDescription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona opcion", "Trajes                       ", "Sacos", "Pantalones", "Chamarras", "Abrigos", "Gabardinas", "Camisas", "Corbatas", "Vestidos", "Faldas", "Blusas", "Sueters", "Chaleco", "Colchas", "Otra..." }));
        jcbDescription.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbDescriptionItemStateChanged(evt);
            }
        });

        jLabel6.setText("Color: ");

        jcbColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona color", "Blanco", "Negro", "Azul", "Cafe", "Rojo", "Morado", "Verde", "Lila", "Gris", "Rosa", "Amarillo", "Naranja", "Turquesa", "Plata" }));
        jcbColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbColorItemStateChanged(evt);
            }
        });

        jLabel7.setText("Precio: ");

        txPrice.setText("0");
        txPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPriceKeyReleased(evt);
            }
        });

        btAdd.setBackground(new java.awt.Color(36, 83, 148));
        btAdd.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btAdd.setForeground(new java.awt.Color(255, 255, 255));
        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-shopping-cart.png"))); // NOI18N
        btAdd.setText("Agregar");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFecha_entrada)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbCustomer, 0, 220, Short.MAX_VALUE)
                            .addComponent(jdFirstDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txItem)
                            .addComponent(txCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 214, Short.MAX_VALUE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbDescription, 0, 184, Short.MAX_VALUE)
                            .addComponent(txPrice)))
                    .addComponent(btAdd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(67, 67, 67))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lbFecha_entrada)
                    .addComponent(jdEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jcbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btClear.setBackground(new java.awt.Color(36, 83, 148));
        btClear.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btClear.setForeground(new java.awt.Color(255, 255, 255));
        btClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-brush.png"))); // NOI18N
        btClear.setText("Limpiar");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btDelete.setBackground(new java.awt.Color(36, 83, 148));
        btDelete.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btDelete.setForeground(new java.awt.Color(255, 255, 255));
        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete_2.png"))); // NOI18N
        btDelete.setText("Eliminar");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbitems.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbitems.setText("No. Articulos: ");

        lbTotalItems.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbTotalItems.setText("0");

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel10.setText("TOTAL:");

        lbTotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbTotal.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbitems)
                .addGap(18, 18, 18)
                .addComponent(lbTotalItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(27, 27, 27)
                .addComponent(lbTotal)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotal)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(lbitems)
                        .addComponent(lbTotalItems)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenu3.setText("Almacen");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/document-archive-folder-icon.png"))); // NOI18N
        jMenuItem1.setText("Notas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hanger-icon.png"))); // NOI18N
        jMenuItem2.setText("Prendas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(btClear)
                .addGap(36, 36, 36)
                .addComponent(btDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSave)
                .addGap(68, 68, 68))
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave)
                    .addComponent(btClear)
                    .addComponent(btDelete))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCustomerItemStateChanged

        cliente = jcbCustomer.getSelectedItem().toString();
        idCliente = jcbCustomer.getSelectedIndex();

        txCustomer.setText(cliente);
    }//GEN-LAST:event_jcbCustomerItemStateChanged

    private void jcbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCustomerActionPerformed
        // TODO add your handling code here: 
        cliente = jcbCustomer.getSelectedItem().toString();
        if (cliente.equals("Otro...")) {
            String s = JOptionPane.showInputDialog(null, "Ingresa nombre del Cliente");
            txCustomer.setText(s.toUpperCase());
            CustomerController ccustomer = new CustomerController();
            int idCustomer = ccustomer.getCountCustomers();
            Customer customer = new Customer(idCustomer, s);
            ArrayList<Object> dataCustomer = new ArrayList<>();
            dataCustomer.add(customer.getId());
            dataCustomer.add(customer.getName());

            ccustomer.save(dataCustomer);
            DefaultComboBoxModel<String> modelCustomer = new DefaultComboBoxModel<>();

            ArrayList<String> list = ccustomer.all();
            modelCustomer.addElement("Selecciona Cliente");

            for (int i = 0; i < list.size(); i++) {
                modelCustomer.addElement(list.get(i));
            }

            jcbCustomer.setModel(modelCustomer);

        }
    }//GEN-LAST:event_jcbCustomerActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        datos[0] = txQuantity.getText();
        datos[1] = txItem.getText();
        datos[2] = jcbDescription.getSelectedItem().toString();
        datos[3] = jcbColor.getSelectedItem().toString();
        datos[4] = color;
        datos[5] = txPrice.getText();
        date1 = getDateString(jdFirstDate);
        date2 = getDateString(jdEndDate);
        System.out.println("" + date1);
        datos[6] = date1;
        datos[7] = date2;

        cantidad = Integer.parseInt(datos[0].toString());
        precio = Double.parseDouble(datos[5].toString());

        importe = cantidad * precio;
        datos[8] = importe;

        DefaultTableModel model = (DefaultTableModel) tableRegister.getModel();
        model.addRow(datos);

        accumTotal = accumTotal + importe;
        numItems = numItems + cantidad;

        lbTotal.setText("" + accumTotal);
        lbTotalItems.setText("" + numItems);

    }//GEN-LAST:event_btAddActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed

        if (date1.isEmpty() || date2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a valid date...", "Error",
                    JOptionPane.WARNING_MESSAGE);

        } else {

            ArrayList<Object> data = new ArrayList<>();
            data.add(txFolio.getText());
            data.add(date1);
            data.add(date2);
            data.add(accumTotal);
            data.add(idCliente);

            cticket.save(data);

            folio = Integer.parseInt(txFolio.getText());

            for (int i = 0; i < tableRegister.getRowCount(); i++) {
                quantity = Integer.parseInt(tableRegister.getValueAt(i, 0).toString());
                item = tableRegister.getValueAt(i, 1).toString();
                color = Integer.parseInt(tableRegister.getValueAt(i, 4).toString());

                String descrip = tableRegister.getValueAt(i, 2).toString();
                price = Double.parseDouble(tableRegister.getValueAt(i, 5).toString());
                amount = Double.parseDouble(tableRegister.getValueAt(i, 8).toString());
                cticket.insertDetail(folio, quantity, item, color, descrip, price, amount, 1, "FINALIZADO");
            }
            clearAll();
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        removeItem();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void tableRegisterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableRegisterKeyReleased
        char cKey = evt.getKeyChar();
        if (cKey == KeyEvent.VK_ENTER) {

            calculate_Total();

        }
    }//GEN-LAST:event_tableRegisterKeyReleased

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        clearAll();
    }//GEN-LAST:event_btClearActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Notas notas = new Notas(this, true);
        notas.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txFolio.setEditable(true);
        txFolio.setBackground(Color.white);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPriceKeyReleased
        char cKey = evt.getKeyChar();
        if (cKey == KeyEvent.VK_ENTER) {

            txQuantity.requestFocus();

        }
    }//GEN-LAST:event_txPriceKeyReleased

    private void txQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txQuantityKeyReleased
        char cKey = evt.getKeyChar();
        if (cKey == KeyEvent.VK_ENTER) {
            btAdd.doClick();
        }
    }//GEN-LAST:event_txQuantityKeyReleased

    private void jcbColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbColorItemStateChanged
        color = jcbColor.getSelectedIndex();
    }//GEN-LAST:event_jcbColorItemStateChanged

    private void jcbDescriptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbDescriptionItemStateChanged
        String prenda = jcbDescription.getSelectedItem().toString();
        txPrice.setText("" + citem.getPrice(prenda));

        item = citem.getItem(prenda);
        txItem.setText(item);

    }//GEN-LAST:event_jcbDescriptionItemStateChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Items item = new Items(this, true);
        item.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void removeItem() {

        DefaultTableModel model = (DefaultTableModel) tableRegister.getModel();
        index = tableRegister.getSelectedRow();

        if (index < 0) {
            JOptionPane.showMessageDialog(null, "\r\n"
                    + "You must select a row from the table", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            int cant = Integer.parseInt(tableRegister.getValueAt(index, 0).toString());
            double auxTotal = Double.parseDouble(model.getValueAt(index, 8).toString());
            accumTotal = accumTotal - auxTotal;
            lbTotal.setText("" + accumTotal);
            numItems = numItems - cant;
            lbTotalItems.setText("" + numItems);
            model.removeRow(index);
        }

    }

    private void calculate_Total() {
        total = 0;
        numItems = 0;
        rows = tableRegister.getRowCount();
        for (int i = 0; i < rows; i++) {
            quantity = Integer.parseInt(tableRegister.getValueAt(i, 0).toString());
            price = Double.parseDouble(tableRegister.getValueAt(i, 5).toString());
            amount = quantity * price;
            tableRegister.setValueAt(amount, i, 8);
            total = total + amount;
            numItems = numItems + quantity;
        }
        accumTotal = total;
        //System.out.println("valor de total actual:" + accumTotal);
        lbTotalItems.setText("" + numItems);
        lbTotal.setText("" + Globales.formatToDecimal(accumTotal));
    }

    private String getDateString(JDateChooser jDateChooser1) {
        Date date = jDateChooser1.getDate();
        String s;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        s = DateFormat.getDateInstance().format(date);
        //   s=dateFormat.format(date);
        return s;

    }

    private void clearAll() {
        txCustomer.setText("");
        jcbCustomer.setSelectedIndex(0);
        jcbDescription.setSelectedIndex(0);
        jcbColor.setSelectedIndex(0);
        txPrice.setText("");
        txItem.setText("");
        lbTotalItems.setText("0");
        lbTotal.setText("0.00");
        txQuantity.setText("");
        Globales.clearTable(tableRegister);
        txFolio.setText("" + cticket.getFolio());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //</editor-fold>
                try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e);
        }

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CashRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbColor;
    private javax.swing.JComboBox<String> jcbCustomer;
    private javax.swing.JComboBox<String> jcbDescription;
    private com.toedter.calendar.JDateChooser jdEndDate;
    private com.toedter.calendar.JDateChooser jdFirstDate;
    private javax.swing.JLabel lbFecha_entrada;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalItems;
    private javax.swing.JLabel lbitems;
    private javax.swing.JTable tableRegister;
    private javax.swing.JTextField txCustomer;
    private javax.swing.JTextField txFolio;
    private javax.swing.JTextField txItem;
    private javax.swing.JTextField txPrice;
    private javax.swing.JTextField txQuantity;
    // End of variables declaration//GEN-END:variables
}
