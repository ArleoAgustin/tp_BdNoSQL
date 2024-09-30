import com.mongodb.client.*;
import org.bson.Document;

import java.util.List;

public class MongoDBCRUD {

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    private static void openConnection(){
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("db_tiendaOnline");
        collection = database.getCollection("productos");
    }

    public MongoDBCRUD() {}

    // Crear producto con atributos adicionales
    public static void createProduct(String name, double price, String category, String description, String imageURL, Document additionalAttributes) {
        openConnection();
        Document product = new Document("name", name)
                .append("price", price)
                .append("category", category)
                .append("description", description)
                .append("imageURL", imageURL);
        if (additionalAttributes != null)
            product.append("additionalAttributes", additionalAttributes);

        collection.insertOne(product);
        System.out.println("Producto creado: " + name);
        mongoClient.close();
    }

    // obtener todos los productos
    public static void readAllProducts() {
        openConnection();
        FindIterable<Document> products = collection.find();
        for (Document product : products) {
            System.out.println(product.toJson());
        }
        mongoClient.close();
    }

    // Buscar producto por nombre o categoría
    public static void searchProductByNameOrCategory(String search) {
        openConnection();
        Document query = new Document("$or", List.of(
                new Document("name", new Document("$regex", search).append("$options", "i")),
                new Document("category", new Document("$regex", search).append("$options", "i"))
        ));
        FindIterable<Document> products = collection.find(query);
        for (Document product : products) {
            System.out.println(product.toJson());
        }
        mongoClient.close();
    }

    // Actualizar un producto
    public static void updateProduct(String name, double newPrice, Document updatedAttributes) {
        openConnection();
        Document query = new Document("name", name);
        Document updateFields = new Document("price", newPrice);
        if (updatedAttributes != null) {
            updateFields.append("additionalAttributes", updatedAttributes);
        }
        Document update = new Document("$set", updateFields);
        collection.updateOne(query, update);
        System.out.println("Producto actualizado: " + name);
        mongoClient.close();
    }


    // Eliminar un producto
    public static void deleteProduct(String name) {
        openConnection();
        Document query = new Document("name", name);
        collection.deleteOne(query);
        System.out.println("Producto eliminado: " + name);
        mongoClient.close();
    }
}