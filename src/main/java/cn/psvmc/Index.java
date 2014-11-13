package cn.psvmc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.psvmc.utils.ZJ_ConfigUtils;
import cn.psvmc.utils.ZJ_FolderUtils;
import freemarker.template.TemplateException;

/**
 * @文件名：Index.java
 * @作用：
 * @作者：张剑
 * @创建时间：2014-2-3
 */
public class Index extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private static String selectTableName = null;
	private static String namespacePrefix = null;
	private static String tablePrefix = null;
	private static String pojoSuffix = null;
	private static String daoSuffix = null;
	private static String daoImplSuffix = null;
	private static String serviceSuffix = null;
	private static String serviceImplSuffix = null;
	private static String controllerSuffix = null;
	private static String outputPath = null;

	private static String host = "127.0.0.1";
	private static String port = "3306";
	private static String database = null;
	private static String charset = "UTF-8";
	private static String username = "root";
	private static String password = "root";

	public Index() {
		initComponents();
		init();
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jDialog1 = new javax.swing.JDialog();
		jFileChooser1 = new javax.swing.JFileChooser();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel3 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel11 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jTextField11 = new javax.swing.JTextField();
		jTextField12 = new javax.swing.JTextField();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jTextField9 = new javax.swing.JTextField();
		jTextField10 = new javax.swing.JTextField();
		jButton4 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();

		jDialog1.setAlwaysOnTop(true);
		jDialog1.setBounds(new java.awt.Rectangle(0, 0, 600, 400));

		jFileChooser1.setApproveButtonText("\u786e\u5b9a");
		jFileChooser1.setApproveButtonToolTipText("\u786e\u5b9a");
		jFileChooser1.setCurrentDirectory(new java.io.File("D:\\代码生成"));
		jFileChooser1.setDialogTitle("\u6587\u4ef6\u5939\u9009\u62e9");
		jFileChooser1.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
		jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
		jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFileChooser1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup().addContainerGap().addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE).addContainerGap()));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jDialog1Layout.createSequentialGroup().addContainerGap().addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

		jFileChooser1.getAccessibleContext().setAccessibleParent(this);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u4ee3\u7801\u751f\u6210\u5668(by\u5f20\u5251)");
		setAlwaysOnTop(true);
		setBounds(new java.awt.Rectangle(100, 100, 335, 440));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setFont(new java.awt.Font("新宋体", 0, 12));
		setForeground(java.awt.Color.white);
		setResizable(false);

		jTabbedPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
		jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

		jPanel3.setLayout(new java.awt.BorderLayout());

		GridBagLayout gbl_jPanel2 = new GridBagLayout();
		gbl_jPanel2.columnWeights = new double[] { 0.0, 1.0 };
		jPanel2.setLayout(gbl_jPanel2);

		jLabel11.setText("port：");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		jPanel2.add(jLabel11, gridBagConstraints);

		jLabel10.setText("host：");
		gridBagConstraints_21 = new java.awt.GridBagConstraints();
		gridBagConstraints_21.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_21.gridx = 0;
		gridBagConstraints_21.gridy = 0;
		gridBagConstraints_21.anchor = java.awt.GridBagConstraints.EAST;
		jPanel2.add(jLabel10, gridBagConstraints_21);

		jTextField11.setText("jTextField11");
		gridBagConstraints_22 = new java.awt.GridBagConstraints();
		gridBagConstraints_22.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_22.gridx = 1;
		gridBagConstraints_22.gridy = 0;
		gridBagConstraints_22.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints_22.weightx = 1.0;
		jPanel2.add(jTextField11, gridBagConstraints_22);

		jTextField12.setText("jTextField12");
		gridBagConstraints_23 = new java.awt.GridBagConstraints();
		gridBagConstraints_23.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_23.gridx = 1;
		gridBagConstraints_23.gridy = 1;
		gridBagConstraints_23.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints_23.weightx = 1.0;
		jPanel2.add(jTextField12, gridBagConstraints_23);

		jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);

		lblDatabase = new JLabel();
		lblDatabase.setText("数据库名：");
		GridBagConstraints gbc_lblDatabase = new GridBagConstraints();
		gbc_lblDatabase.anchor = GridBagConstraints.EAST;
		gbc_lblDatabase.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatabase.gridx = 0;
		gbc_lblDatabase.gridy = 2;
		jPanel2.add(lblDatabase, gbc_lblDatabase);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		jPanel2.add(textField_1, gbc_textField_1);

		label_2 = new JLabel();
		label_2.setText("字符编码：");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		jPanel2.add(label_2, gbc_label_2);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		jPanel2.add(textField_2, gbc_textField_2);
		jLabel12 = new javax.swing.JLabel();

		jLabel12.setText("\u7528\u6237\u540d\uff1a");
		gridBagConstraints_25 = new java.awt.GridBagConstraints();
		gridBagConstraints_25.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_25.gridx = 0;
		gridBagConstraints_25.gridy = 4;
		gridBagConstraints_25.anchor = java.awt.GridBagConstraints.EAST;
		jPanel2.add(jLabel12, gridBagConstraints_25);
		jTextField13 = new javax.swing.JTextField();

		jTextField13.setText("jTextField13");
		gridBagConstraints_24 = new java.awt.GridBagConstraints();
		gridBagConstraints_24.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_24.gridx = 1;
		gridBagConstraints_24.gridy = 4;
		gridBagConstraints_24.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints_24.weightx = 1.0;
		jPanel2.add(jTextField13, gridBagConstraints_24);
		jLabel13 = new javax.swing.JLabel();

		jLabel13.setText("\u5bc6\u7801\uff1a");
		gridBagConstraints_26 = new java.awt.GridBagConstraints();
		gridBagConstraints_26.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_26.gridx = 0;
		gridBagConstraints_26.gridy = 5;
		gridBagConstraints_26.anchor = java.awt.GridBagConstraints.EAST;
		jPanel2.add(jLabel13, gridBagConstraints_26);
		jTextField14 = new javax.swing.JTextField();

		jTextField14.setText("jTextField14");
		gridBagConstraints_27 = new java.awt.GridBagConstraints();
		gridBagConstraints_27.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_27.gridx = 1;
		gridBagConstraints_27.gridy = 5;
		gridBagConstraints_27.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints_27.weightx = 1.0;
		jPanel2.add(jTextField14, gridBagConstraints_27);
		jButton3 = new javax.swing.JButton();

		jButton3.setText("\u6570\u636e\u5e93\u4fee\u6539");
		gridBagConstraints_28 = new java.awt.GridBagConstraints();
		gridBagConstraints_28.gridx = 0;
		gridBagConstraints_28.gridy = 7;
		gridBagConstraints_28.gridwidth = 2;
		gridBagConstraints_28.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel2.add(jButton3, gridBagConstraints_28);

		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jTabbedPane1.addTab("\u6570\u636e\u5e93\u8fde\u63a5\u914d\u7f6e", jPanel3);

		GridBagLayout gbl_jPanel1 = new GridBagLayout();
		gbl_jPanel1.columnWeights = new double[] { 0.0, 1.0 };
		jPanel1.setLayout(gbl_jPanel1);

		label_1 = new JLabel("删除原文件：");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		jPanel1.add(label_1, gbc_label_1);

		checkBox = new JCheckBox("");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.anchor = GridBagConstraints.WEST;
		gbc_checkBox.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 0;
		jPanel1.add(checkBox, gbc_checkBox);

		label = new JLabel("过滤表名：");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		jPanel1.add(label, gbc_label);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		jPanel1.add(textField, gbc_textField);
		textField.setColumns(10);

		jLabel2.setText("\u547d\u540d\u7a7a\u95f4\u524d\u7f00\uff1a");
		gridBagConstraints_3 = new java.awt.GridBagConstraints();
		gridBagConstraints_3.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_3.gridx = 0;
		gridBagConstraints_3.gridy = 2;
		gridBagConstraints_3.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel2, gridBagConstraints_3);

		jTextField2.setText("jTextField2");
		gridBagConstraints_4 = new java.awt.GridBagConstraints();
		gridBagConstraints_4.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_4.gridx = 1;
		gridBagConstraints_4.gridy = 2;
		gridBagConstraints_4.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(jTextField2, gridBagConstraints_4);

		jLabel3.setText("\u8868\u540d\u524d\u7f00\uff1a");
		gridBagConstraints_5 = new java.awt.GridBagConstraints();
		gridBagConstraints_5.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_5.gridx = 0;
		gridBagConstraints_5.gridy = 3;
		gridBagConstraints_5.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel3, gridBagConstraints_5);

		jTextField3.setText("jTextField3");
		gridBagConstraints_6 = new java.awt.GridBagConstraints();
		gridBagConstraints_6.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_6.gridx = 1;
		gridBagConstraints_6.gridy = 3;
		gridBagConstraints_6.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(jTextField3, gridBagConstraints_6);

		jLabel4.setText("pojo\u540e\u7f00\uff1a");
		gridBagConstraints_7 = new java.awt.GridBagConstraints();
		gridBagConstraints_7.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_7.gridx = 0;
		gridBagConstraints_7.gridy = 4;
		gridBagConstraints_7.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel4, gridBagConstraints_7);

		jLabel5.setText("dao\u540e\u7f00\uff1a");
		gridBagConstraints_8 = new java.awt.GridBagConstraints();
		gridBagConstraints_8.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_8.gridx = 0;
		gridBagConstraints_8.gridy = 5;
		gridBagConstraints_8.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel5, gridBagConstraints_8);

		jTextField4.setText("jTextField4");
		gridBagConstraints_9 = new java.awt.GridBagConstraints();
		gridBagConstraints_9.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_9.gridx = 1;
		gridBagConstraints_9.gridy = 4;
		gridBagConstraints_9.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(jTextField4, gridBagConstraints_9);

		jTextField5.setText("jTextField5");
		gridBagConstraints_10 = new java.awt.GridBagConstraints();
		gridBagConstraints_10.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_10.gridx = 1;
		gridBagConstraints_10.gridy = 5;
		gridBagConstraints_10.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(jTextField5, gridBagConstraints_10);

		jTextField6.setText("jTextField6");
		gridBagConstraints_11 = new java.awt.GridBagConstraints();
		gridBagConstraints_11.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_11.gridx = 1;
		gridBagConstraints_11.gridy = 6;
		gridBagConstraints_11.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(jTextField6, gridBagConstraints_11);

		jButton2.setText("\u751f\u6210\u4f4d\u7f6e");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton2MouseClicked(evt);
			}
		});
		gridBagConstraints_12 = new java.awt.GridBagConstraints();
		gridBagConstraints_12.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_12.gridx = 0;
		gridBagConstraints_12.gridy = 10;
		gridBagConstraints_12.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints_12.weightx = 0.1;
		jPanel1.add(jButton2, gridBagConstraints_12);

		jLabel6.setText("daoImpl\u540e\u7f00\uff1a");
		gridBagConstraints_13 = new java.awt.GridBagConstraints();
		gridBagConstraints_13.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_13.gridx = 0;
		gridBagConstraints_13.gridy = 6;
		gridBagConstraints_13.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel6, gridBagConstraints_13);

		jLabel7.setText("service\u540e\u7f00\uff1a");
		gridBagConstraints_14 = new java.awt.GridBagConstraints();
		gridBagConstraints_14.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_14.gridx = 0;
		gridBagConstraints_14.gridy = 7;
		gridBagConstraints_14.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel7, gridBagConstraints_14);

		jLabel8.setText("serviceImpl\u540e\u7f00\uff1a");
		gridBagConstraints_15 = new java.awt.GridBagConstraints();
		gridBagConstraints_15.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_15.gridx = 0;
		gridBagConstraints_15.gridy = 8;
		gridBagConstraints_15.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel8, gridBagConstraints_15);

		jLabel9.setText("controller\u540e\u7f00\uff1a");
		gridBagConstraints_16 = new java.awt.GridBagConstraints();
		gridBagConstraints_16.insets = new Insets(0, 0, 5, 5);
		gridBagConstraints_16.gridx = 0;
		gridBagConstraints_16.gridy = 9;
		gridBagConstraints_16.anchor = java.awt.GridBagConstraints.WEST;
		jPanel1.add(jLabel9, gridBagConstraints_16);

		jTextField7.setText("jTextField7");
		gridBagConstraints_17 = new java.awt.GridBagConstraints();
		gridBagConstraints_17.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_17.gridx = 1;
		gridBagConstraints_17.gridy = 7;
		gridBagConstraints_17.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(jTextField7, gridBagConstraints_17);

		jTextField8.setText("jTextField8");
		gridBagConstraints_18 = new java.awt.GridBagConstraints();
		gridBagConstraints_18.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_18.gridx = 1;
		gridBagConstraints_18.gridy = 8;
		gridBagConstraints_18.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(jTextField8, gridBagConstraints_18);

		jTextField9.setText("jTextField9");
		gridBagConstraints_19 = new java.awt.GridBagConstraints();
		gridBagConstraints_19.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_19.gridx = 1;
		gridBagConstraints_19.gridy = 9;
		gridBagConstraints_19.fill = java.awt.GridBagConstraints.HORIZONTAL;
		jPanel1.add(jTextField9, gridBagConstraints_19);

		jTextField10.setText("jTextField10");
		gridBagConstraints_20 = new java.awt.GridBagConstraints();
		gridBagConstraints_20.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints_20.gridx = 1;
		gridBagConstraints_20.gridy = 10;
		gridBagConstraints_20.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints_20.weightx = 0.7;
		jPanel1.add(jTextField10, gridBagConstraints_20);

		jButton4.setText("\u4fee\u6539");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 11;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		jPanel1.add(jButton4, gridBagConstraints);

		jTabbedPane1.addTab("\u751f\u6210\u914d\u7f6e", jPanel1);

		getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

		jButton1.setText("\u4ee3\u7801\u751f\u6210");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1, java.awt.BorderLayout.SOUTH);
	}// </editor-fold>
		// GEN-END:initComponents
		// GEN-END:initComponents

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
		jDialog1.setVisible(true);
	}

	private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (evt.getActionCommand().equals("ApproveSelection")) {
			this.jTextField10.setText(jFileChooser1.getSelectedFile().getAbsolutePath());
			jDialog1.setVisible(false);
		} else {
			jDialog1.setVisible(false);
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if (checkBox.isSelected()) {
				System.out.println("****************************************************************");
				ZJ_FolderUtils.delFolder(outputPath);
				System.out.println("****************************************************************");
			}
			CodeCreater.mainCreator();
			JOptionPane.showMessageDialog(this, "代码生成完毕！");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "输出错误！");
		} catch (TemplateException e) {
			JOptionPane.showMessageDialog(this, "模板加载错误！");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "加载错误！");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "数据库连接有误！");
		}

	}

	/**
	 * 修改方法
	 * 
	 * @param evt
	 * @author 张剑
	 * @date 2014年11月13日 上午10:25:48
	 */
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		ZJ_ConfigUtils.setProperty( "host", jTextField11.getText());
		ZJ_ConfigUtils.setProperty( "port", jTextField12.getText());
		ZJ_ConfigUtils.setProperty( "database", textField_1.getText());
		ZJ_ConfigUtils.setProperty( "charset", textField_2.getText());
		ZJ_ConfigUtils.setProperty( "username", jTextField13.getText());
		ZJ_ConfigUtils.setProperty( "password", jTextField14.getText());
		init();
		JOptionPane.showMessageDialog(this, "修改成功！");
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		ZJ_ConfigUtils.setProperty("database", this.textField_1.getText());
		ZJ_ConfigUtils.setProperty("selectTableName", this.textField.getText());
		ZJ_ConfigUtils.setProperty("namespacePrefix", this.jTextField2.getText());
		ZJ_ConfigUtils.setProperty("tablePrefix", this.jTextField3.getText());
		ZJ_ConfigUtils.setProperty("pojoSuffix", this.jTextField4.getText());
		ZJ_ConfigUtils.setProperty("daoSuffix", this.jTextField5.getText());
		ZJ_ConfigUtils.setProperty("daoImplSuffix", this.jTextField6.getText());
		ZJ_ConfigUtils.setProperty("serviceSuffix", this.jTextField7.getText());
		ZJ_ConfigUtils.setProperty("serviceImplSuffix", this.jTextField8.getText());
		ZJ_ConfigUtils.setProperty("controllerSuffix", this.jTextField9.getText());
		ZJ_ConfigUtils.setProperty("outputPath", this.jTextField10.getText());
		init();
		JOptionPane.showMessageDialog(this, "修改成功！");
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {

	}

	/**
	 * 初始化方法
	 * 
	 * @author 张剑
	 * @date 2014年11月13日 上午10:19:22
	 */
	private void init() {
		selectTableName = ZJ_ConfigUtils.getProperty("selectTableName");
		namespacePrefix = ZJ_ConfigUtils.getProperty("namespacePrefix");
		tablePrefix = ZJ_ConfigUtils.getProperty("tablePrefix");
		pojoSuffix = ZJ_ConfigUtils.getProperty("pojoSuffix");
		daoSuffix = ZJ_ConfigUtils.getProperty("daoSuffix");
		daoImplSuffix = ZJ_ConfigUtils.getProperty("daoImplSuffix");
		serviceSuffix = ZJ_ConfigUtils.getProperty("serviceSuffix");
		serviceImplSuffix = ZJ_ConfigUtils.getProperty("serviceImplSuffix");
		controllerSuffix = ZJ_ConfigUtils.getProperty("controllerSuffix");
		outputPath = ZJ_ConfigUtils.getProperty("outputPath");

		host = ZJ_ConfigUtils.getProperty( "host");
		port = ZJ_ConfigUtils.getProperty( "port");
		database = ZJ_ConfigUtils.getProperty( "database");
		charset = ZJ_ConfigUtils.getProperty( "charset");
		username = ZJ_ConfigUtils.getProperty( "username");
		password = ZJ_ConfigUtils.getProperty( "password");
		this.textField.setText(selectTableName);
		this.jTextField2.setText(namespacePrefix);
		this.jTextField3.setText(tablePrefix);
		this.jTextField4.setText(pojoSuffix);
		this.jTextField5.setText(daoSuffix);
		this.jTextField6.setText(daoImplSuffix);
		this.jTextField7.setText(serviceSuffix);
		this.jTextField8.setText(serviceImplSuffix);
		this.jTextField9.setText(controllerSuffix);
		this.jTextField10.setText(outputPath);
		this.jTextField11.setText(host);
		this.jTextField12.setText(port);
		this.textField_1.setText(database);
		this.textField_2.setText(charset);
		this.jTextField13.setText(username);
		this.jTextField14.setText(password);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Index().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JFileChooser jFileChooser1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField11;
	private javax.swing.JTextField jTextField12;
	private javax.swing.JTextField jTextField13;
	private javax.swing.JTextField jTextField14;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	private JLabel label;
	private GridBagConstraints gridBagConstraints_3;
	private GridBagConstraints gridBagConstraints_4;
	private GridBagConstraints gridBagConstraints_5;
	private GridBagConstraints gridBagConstraints_6;
	private GridBagConstraints gridBagConstraints_7;
	private GridBagConstraints gridBagConstraints_8;
	private GridBagConstraints gridBagConstraints_9;
	private GridBagConstraints gridBagConstraints_10;
	private GridBagConstraints gridBagConstraints_11;
	private GridBagConstraints gridBagConstraints_12;
	private GridBagConstraints gridBagConstraints_13;
	private GridBagConstraints gridBagConstraints_14;
	private GridBagConstraints gridBagConstraints_15;
	private GridBagConstraints gridBagConstraints_16;
	private GridBagConstraints gridBagConstraints_17;
	private GridBagConstraints gridBagConstraints_18;
	private GridBagConstraints gridBagConstraints_19;
	private GridBagConstraints gridBagConstraints_20;
	private JTextField textField;
	private GridBagConstraints gridBagConstraints_21;
	private GridBagConstraints gridBagConstraints_22;
	private GridBagConstraints gridBagConstraints_23;
	private GridBagConstraints gridBagConstraints_24;
	private GridBagConstraints gridBagConstraints_25;
	private GridBagConstraints gridBagConstraints_26;
	private GridBagConstraints gridBagConstraints_27;
	private GridBagConstraints gridBagConstraints_28;
	private JCheckBox checkBox;
	private JLabel label_1;
	private JLabel lblDatabase;
	private JLabel label_2;
	private JTextField textField_1;
	private JTextField textField_2;

}