package ec.edu.ups.modelo;
public class Telefono {
    
    private String codigo; //tamano 4
    private String numero; //tamano 12
    private String tipo; //tamano 22
    private String operadora;//tamano 32
    private String cedula; //tamano 12
    //81 bits

    public Telefono(String codigo, String numero, String tipo, String operadora, String cedula) {
        this.setCodigo(codigo);
        this.setNumero(numero);
        this.setTipo(tipo);
        this.setOperadora(operadora);
        this.setCedula(cedula);
    }
    
    
    public String getCodigo() {
        return codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = validarEspacios(cedula, 10);
    }

   

    public void setCodigo(String codigo) {
        this.codigo = validarEspacios(codigo, 2);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = validarEspacios(numero, 10);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = validarEspacios(tipo, 20);
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = validarEspacios(operadora, 30);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        
        return hash;
    }
    
    
    public String validarEspacios(String cadena,int lon){
        if(cadena.length()==lon){
            return cadena;
        }
        else{
            if(cadena.length()<lon){
            return llenarEspacios(cadena, lon);
        }else{
                return  cortarEspacios(cadena, lon);
            }
        }
    }
    public String llenarEspacios(String cadena, int lon){
        return String.format("%-"+lon+"s", cadena);
    }
    public String cortarEspacios(String cadena, int lon){
        return cadena.substring(0,lon);
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefono other = (Telefono) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefono{" + "codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora + '}';
    }
    
    
}
