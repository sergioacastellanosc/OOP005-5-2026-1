package practicaguijava;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class AplicacionNotasGUI extends JFrame {
    private static final Color COLOR_FONDO = new Color (245 , 248 , 252) ;
    private static final Color COLOR_TITULO = new Color (20 , 70 , 140) ;
    private static final Color COLOR_BOTON_AZUL = new Color (30 , 100 , 180);
    private static final Color COLOR_BOTON_VERDE = new Color (40 , 140 , 90);
    private static final Color COLOR_BOTON_ROJO = new Color (180 , 60 , 60) ;
    private static final Color COLOR_BOTON_GRIS = new Color (90 , 100 , 110);
    private JTextField txtCodigo ;
    private JTextField txtNombre ;
    private JTextField txtNota1 ;
    private JTextField txtNota2 ;
    private JTextField txtNota3 ;
    private JComboBox < String > cmbPrograma ;
    private JRadioButton rbDiurna ;
    private JRadioButton rbNocturna ;
    private ButtonGroup grupoJornada ;
    private JTable tablaEstudiantes ;
    private DefaultTableModel modeloTabla ;
    private JLabel lblEstado ;
    private JLabel lblResumen ;
    
    public AplicacionNotasGUI(){
        configurarVentana();
        inicializarComponentes();
    }
    
    private void configurarVentana(){
        setTitle("Registro de estudiantes");
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        JPanel contenedor = new JPanel(new BorderLayout(10, 10));
        contenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contenedor.setBackground(COLOR_FONDO);
        setContentPane(contenedor);
        JPanel panelTitulo = crearPanelTitulo();
        JPanel panelFormulario = crearPanelFormulario();
        JScrollPane panelTabla = crearPanelTabla();
        JPanel panelInferior = crearPanelInferior();
        contenedor . add ( panelTitulo , BorderLayout . NORTH );
        contenedor . add ( panelFormulario , BorderLayout . WEST );
        contenedor . add ( panelTabla , BorderLayout . CENTER );
        contenedor . add ( panelInferior , BorderLayout . SOUTH );
    }
    
    
    private JPanel crearPanelTitulo(){
        JPanel panel = new JPanel();
        panel . setBackground ( COLOR_FONDO );
        JLabel titulo = new JLabel (" Sistema de registro de estudiantes ");
        titulo . setFont ( new Font (" Arial ", Font . BOLD , 26) );
        titulo . setForeground ( COLOR_TITULO ) ;
        panel . add ( titulo );
        return panel ;
    }
    
    private JPanel crearPanelFormulario(){
        JPanel panel = new JPanel(new GridBagLayout());
        panel . setBackground ( COLOR_FONDO );
        panel . setBorder ( BorderFactory . createTitledBorder (" Datos del estudiante ") );
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6 , 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtCodigo = new JTextField (15) ;
        txtNombre = new JTextField (15) ;
        txtNota1 = new JTextField (15) ;
        txtNota2 = new JTextField (15) ;
        txtNota3 = new JTextField (15) ;
        cmbPrograma = new JComboBox<>(new String[]{"Ingenieria Electronica", "Ingenieria Mecatronica", "Ingenieria de sistemas", "Tecnologia electronica", "Otro"});
        rbDiurna = new JRadioButton (" Diurna ") ;
        rbNocturna = new JRadioButton (" Nocturna ");
        rbDiurna . setBackground ( COLOR_FONDO ) ;
        rbNocturna . setBackground ( COLOR_FONDO ) ;
        rbDiurna . setSelected ( true );
        grupoJornada = new ButtonGroup () ;
        grupoJornada . add ( rbDiurna ) ;
        grupoJornada . add ( rbNocturna );
        JPanel panelJornada = new JPanel ( new FlowLayout ( FlowLayout . LEFT, 5, 0) );
        panelJornada . setBackground ( COLOR_FONDO ) ;
        panelJornada . add ( rbDiurna ) ;
        panelJornada . add ( rbNocturna );
        JButton btnAgregar = new JButton (" Agregar ");
        JButton btnLimpiar = new JButton (" Limpiar ");
        JButton btnEliminar = new JButton (" Eliminar ");
        JButton btnGuardarCSV = new JButton (" Guardar CSV ") ;
        JButton btnSalir = new JButton (" Salir ") ;
        estilizarBoton ( btnAgregar , COLOR_BOTON_VERDE );
        estilizarBoton ( btnLimpiar , COLOR_BOTON_GRIS ) ;
        estilizarBoton ( btnEliminar , COLOR_BOTON_ROJO );
        estilizarBoton ( btnGuardarCSV , COLOR_BOTON_AZUL ) ;
        estilizarBoton ( btnSalir , COLOR_BOTON_ROJO ) ;
        agregarFila ( panel , gbc , 0, " Codigo :", txtCodigo );
        agregarFila ( panel , gbc , 1, " Nombre :", txtNombre );
        agregarFila ( panel , gbc , 2, " Programa :", cmbPrograma ) ;
        agregarFila ( panel , gbc , 3, " Jornada :", panelJornada ) ;
        agregarFila ( panel , gbc , 4, " Nota 1:", txtNota1 );
        agregarFila ( panel , gbc , 5, " Nota 2:", txtNota2 );
        agregarFila ( panel , gbc , 6, " Nota 3:", txtNota3 );
        gbc . gridx = 0;
        gbc . gridy = 7;
        gbc . gridwidth = 1;
        panel . add ( btnAgregar , gbc ) ;
        gbc . gridx = 1;
        gbc . gridy = 7;
        panel . add ( btnLimpiar , gbc ) ;
        gbc . gridx = 0;
        gbc . gridy = 8;
        panel . add ( btnEliminar , gbc );
        gbc . gridx = 1;
        gbc . gridy = 8;
        panel . add ( btnGuardarCSV , gbc ) ;
        gbc . gridx = 0;
        gbc . gridy = 9;
        gbc . gridwidth = 2;
        panel . add ( btnSalir , gbc ) ;
        btnAgregar . addActionListener (e -> agregarEstudiante () ) ;
        btnLimpiar . addActionListener (e -> limpiarFormulario () ) ;
        btnEliminar . addActionListener (e -> eliminarFilaSeleccionada () );
        btnGuardarCSV . addActionListener ( e -> guardarCSV () );
        btnSalir . addActionListener ( e -> salirAplicacion () );
        return panel;
    }
    
    private void agregarFila(JPanel panel, GridBagConstraints gbc, int fila, String textoEtiqueta, JComponent componente){
        gbc . gridwidth = 1;
        gbc . gridx = 0;
        gbc . gridy = fila ;
        panel . add (new JLabel ( textoEtiqueta ) , gbc );
        gbc . gridx = 1;
        gbc . gridy = fila ;
        panel . add ( componente , gbc ) ;
    }
    
    private void estilizarBoton ( JButton boton , Color color ) {
    boton . setBackground ( color );
    boton . setForeground ( Color . WHITE );
    boton . setFocusPainted ( false ) ;
    boton . setFont (new Font (" Arial ", Font . BOLD , 12) );
    }
    
    private JScrollPane crearPanelTabla (){ 
        String[] columnas = { 
            "Codigo", 
            "Nombre", 
            "Programa", 
            "Jornada", 
            "Nota 1", 
            "Nota 2", 
            "Nota 3", 
            "Definitiva", 
            "Estado"
        };
        
        modeloTabla = new DefaultTableModel ( columnas , 0) {
            @Override
            public boolean isCellEditable ( int row , int column ) {
            return false ;
            }
        };
        tablaEstudiantes = new JTable ( modeloTabla );
        tablaEstudiantes . setFillsViewportHeight ( true );
        tablaEstudiantes . setSelectionMode ( ListSelectionModel.SINGLE_SELECTION );
        return new JScrollPane ( tablaEstudiantes ) ;
    }
    
    private JPanel crearPanelInferior (){
        JPanel panel = new JPanel ( new GridLayout (2 , 1) );
        panel . setBackground ( COLOR_FONDO );
        lblEstado = new JLabel (" Ingrese los datos del estudiante .");
        lblResumen = new JLabel (" Registros : 0 | Promedio : 0.00 | Aprueban: 0 | Reprueban : 0") ;
        lblEstado . setBorder ( BorderFactory . createEmptyBorder (5 , 10 , 5, 10));
        lblResumen . setBorder ( BorderFactory . createEmptyBorder (5 , 10 , 5 ,10) ) ;
        panel . add ( lblEstado ) ;
        panel . add ( lblResumen );
        return panel ;
    }
    
    private void agregarEstudiante (){
        String codigo = txtCodigo . getText () . trim () ;
        String nombre = txtNombre . getText () . trim () ;
        String programa = cmbPrograma . getSelectedItem () . toString () ;
        String jornada = obtenerJornadaSeleccionada () ;
        if ( codigo . isEmpty () || nombre . isEmpty () ){
            mostrarMensaje (" Error : el codigo y el nombre son obligatorios.");
            return ;
        }
        try {
            double nota1 = convertirNota ( txtNota1 . getText () );
            double nota2 = convertirNota ( txtNota2 . getText () );
            double nota3 = convertirNota ( txtNota3 . getText () );
            Estudiante estudiante = new Estudiante (codigo, nombre, programa, jornada, nota1, nota2, nota3);
            Object[] fila = {estudiante . getCodigo () ,estudiante . getNombre () ,estudiante . getPrograma () ,estudiante . getJornada () ,estudiante . getNota1 () ,
            estudiante . getNota2 () ,estudiante . getNota3 () ,String . format ( Locale . US , " %.2f", estudiante.calcularDefinitiva () ),estudiante . obtenerEstado () };
            modeloTabla . addRow ( fila ) ;
            limpiarFormulario () ;
            actualizarResumen () ;
        } catch(NumberFormatException ex){
            mostrarMensaje (" Error : las notas deben ser valores numericos .") ;
        } catch (IllegalArgumentException ex){
            mostrarMensaje (" Error : " + ex . getMessage () ) ;
        }
    }
    
    private String obtenerJornadaSeleccionada () {
        if ( rbNocturna . isSelected () ) {
            return " Nocturna ";
        } else {
            return " Diurna ";
        }
    }
    
    private double convertirNota ( String texto ){
        if(texto . trim () . isEmpty () ){
            throw new IllegalArgumentException(" todos los campos de notas son obligatorios .");
        }
        double nota = Double . parseDouble ( texto . trim () ) ;
        if ( nota < 0.0 || nota > 5.0) {
            throw new IllegalArgumentException (" cada nota debe estar entre 0.0 y 5.0. ") ;
        }
        return nota ;
    }
    
    
    private void limpiarFormulario () {
        txtCodigo . setText ("");
        txtNombre . setText ("");
        txtNota1 . setText ("") ;
        txtNota2 . setText ("") ;
        txtNota3 . setText ("") ;
        cmbPrograma . setSelectedIndex (0) ;
        rbDiurna . setSelected ( true );
        txtCodigo . requestFocus () ;
    }
    
    private void eliminarFilaSeleccionada () {
        int filaSeleccionada = tablaEstudiantes . getSelectedRow () ;
        if ( filaSeleccionada == -1) {
            mostrarMensaje (" Seleccione una fila para eliminar .") ;
            return ;
        }
        int opcion = JOptionPane . showConfirmDialog (
            this ,
            " Desea eliminar el registro seleccionado ?",
            " Confirmar eliminacion ",
            JOptionPane . YES_NO_OPTION
        );
        if ( opcion == JOptionPane . YES_OPTION ) {
            modeloTabla . removeRow ( filaSeleccionada );
            mostrarMensaje (" Registro eliminado correctamente .");
            actualizarResumen () ;
        }
    }
    
    
    private void actualizarResumen () {
    int total = modeloTabla . getRowCount () ;
    double sumaDefinitivas = 0.0;
    int aprueban = 0;
    int reprueban = 0;
    for ( int i = 0; i < total ; i ++) {
        String definitivaTexto = modeloTabla . getValueAt (i , 7) .toString () ;
        double definitiva = Double . parseDouble ( definitivaTexto .replace (",", ".") );
        sumaDefinitivas += definitiva ;
        String estado = modeloTabla . getValueAt (i , 8) . toString () ;
        if ( estado . equals (" Aprueba ") ) {
            aprueban ++;
        } else {
            reprueban ++;
        }
    }
    double promedio = 0.0;
    if ( total > 0) {
        promedio = sumaDefinitivas / total ;
    }
    lblResumen . setText (
        " Registros : " + total
            + " | Promedio : " + String . format ( Locale . US , " %.2f", promedio )
            + " | Aprueban : " + aprueban
            + " | Reprueban : " + reprueban
        );
    }
    
    
    private void guardarCSV (){
        if ( modeloTabla . getRowCount () == 0) {
            mostrarMensaje ("No hay registros para guardar .");
            return ;
        }
        
        JFileChooser selector = new JFileChooser () ;
        selector . setDialogTitle (" Guardar archivo CSV ") ;
        selector . setSelectedFile ( new File (" estudiantes . csv ")) ;
        int opcion = selector . showSaveDialog ( this );
        if ( opcion != JFileChooser . APPROVE_OPTION ) {
            mostrarMensaje (" Guardado cancelado .") ;
            return ;
        }
        File archivo = selector . getSelectedFile () ;
        if (! archivo . getName () . toLowerCase () . endsWith (". csv ") ) {
            File carpeta = archivo . getParentFile () ;
            if ( carpeta != null ){
                archivo = new File ( carpeta , archivo . getName () + ". csv ") ;
            }else{
                archivo = new File ( archivo . getName () + ". csv ");
            }
        }
        try ( PrintWriter salida = new PrintWriter ( archivo , "UTF -8")){
            for ( int col = 0; col < modeloTabla . getColumnCount () ; col ++){
                salida . print ( modeloTabla . getColumnName ( col )) ;
                if ( col < modeloTabla . getColumnCount () - 1) {
                    salida . print (";");
                }
            }
            salida . println () ;
            for ( int fila = 0; fila < modeloTabla . getRowCount () ; fila ++){
                for ( int col = 0; col < modeloTabla . getColumnCount () ; col++) {
                    salida . print ( modeloTabla . getValueAt ( fila , col )) ;
                    if ( col < modeloTabla . getColumnCount () - 1) {
                        salida . print (";");
                    }
                }
                salida . println () ;
            }
            mostrarMensaje (" Archivo CSV guardado correctamente .") ;
        } catch ( IOException ex ) {
            mostrarMensaje (" Error al guardar el archivo CSV .") ;
        }    
    }

    private void salirAplicacion (){
        int opcion = JOptionPane . showConfirmDialog (
                            this,
                            "Desea salir de la aplicacion?",
                            "Confirmar salida",
                            JOptionPane . YES_NO_OPTION
        );
        if ( opcion == JOptionPane . YES_OPTION ) {
            System . exit (0) ;
        }
    }
    
    private void mostrarMensaje ( String mensaje ) {
        lblEstado . setText ( mensaje );
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    
    
    
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{new AplicacionNotasGUI().setVisible(true);});
    }
}    
   
    
    
    
    
    
    
    
    
    



    
