package family_tree.Writer;

import family_tree.family_tree_Angelina.FamilyTree;

import java.io.*;

public class FileHandler implements WriterHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // или пробрасывайте исключение, если это необходимо
        }
    }
}



//public class FileHandler implements WriterHandler {
//
//    @Override
//    public void saveFamilyTree(FamilyTree familyTree, String filePath) throws Exception {
//        try (FileOutputStream fileOut = new FileOutputStream(filePath);
//             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
//            out.writeObject(familyTree);
//        }
//    }
//
//    @Override
//    public FamilyTree loadFamilyTree(String filePath) throws Exception {
//        try (FileInputStream fileIn = new FileInputStream(filePath);
//             ObjectInputStream in = new ObjectInputStream(fileIn)) {
//            return (FamilyTree) in.readObject();
//        }
//    }
//}
