package cl.samf.individual6;

public class ImageList {

    String imagenUrl;
    String texto;

    public ImageList(String imagenUrl, String texto) {
        this.imagenUrl = imagenUrl;
        this.texto = texto;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
