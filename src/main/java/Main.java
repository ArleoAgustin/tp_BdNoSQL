import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
public class Main {
    public static void main(String[] args) {
/*
        MongoDBCRUD.createProduct("Smartphone Pro", 999.99, "Electrónica", "Smartphone de alta gama con cámara triple", "url_imagen_smartphone",
                null);
        MongoDBCRUD.createProduct("Televisor 4K", 499.99, "Electrónica", "Televisor de 55 pulgadas con resolución 4K", "url_imagen_tv",
                new Document("tamaño", "55 pulgadas").append("resolución", "4K"));
        MongoDBCRUD.createProduct("Audífonos Inalámbricos", 199.99, "Electrónica", "Audífonos con cancelación de ruido", "url_imagen_audifonos",
                new Document("color", "Blanco").append("tipo", "Inalámbrico"));
        MongoDBCRUD.createProduct("Smartwatch Deportivo", 149.99, "Electrónica", "Reloj inteligente con monitor de actividad física", "url_imagen_smartwatch",
                new Document("color", "Negro").append("resistencia al agua", "50m"));
        MongoDBCRUD.createProduct("Tablet", 399.99, "Electrónica", "Tablet de 10 pulgadas con pantalla HD", "url_imagen_tablet",
                null);
        MongoDBCRUD.createProduct("Teclado Mecánico", 89.99, "Electrónica", "Teclado mecánico retroiluminado para gaming", "url_imagen_teclado",
                new Document("tipo de switch", "Rojo").append("retroiluminación", "RGB"));
        MongoDBCRUD.createProduct("Ratón Gamer", 49.99, "Electrónica", "Ratón ergonómico con 7 botones programables", "url_imagen_raton",
                new Document("dpi", "16000").append("color", "Negro"));
        MongoDBCRUD.createProduct("Consola de Videojuegos", 299.99, "Electrónica", "Consola de última generación con gráficos 4K", "url_imagen_consola",
                new Document("almacenamiento", "1TB").append("color", "Negro"));
        MongoDBCRUD.createProduct("Cámara Profesional", 799.99, "Fotografía", "Cámara réflex con lente intercambiable", "url_imagen_camara",
                null);
        MongoDBCRUD.createProduct("Lente 50mm", 299.99, "Fotografía", "Lente fijo de 50mm con apertura f/1.8", "url_imagen_lente",
                new Document("apertura", "f/1.8").append("montura", "Canon EF"));
        MongoDBCRUD.createProduct("Trípode", 79.99, "Fotografía", "Trípode ajustable con soporte para cámara", "url_imagen_tripode",
                new Document("altura máxima", "1.5m").append("material", "Aluminio"));
        MongoDBCRUD.createProduct("Refrigerador", 999.99, "Electrodomésticos", "Refrigerador de doble puerta con tecnología No Frost", "url_imagen_refrigerador",
                null);
*/
        // Leer todos los productos
        MongoDBCRUD.readAllProducts();

        // Buscar producto por nombre o categoría
        MongoDBCRUD.searchProductByNameOrCategory("Electrónica"); //categoria
        MongoDBCRUD.searchProductByNameOrCategory("Trípode"); //nombre

        // Actualizar un producto
        MongoDBCRUD.updateProduct("Smartphone Pro", 1199.99, new Document("Ram", "5GB").append("Almacenamiento", "256GB"));

        // Eliminar un producto
     //   MongoDBCRUD.deleteProduct("Laptop Gamer");
    }
}
