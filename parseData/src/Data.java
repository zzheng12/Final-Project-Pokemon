import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Data {
    public static final String BASE_STATS = "Base Stats.csv";
    public static final String MOVE_LIST = "Move List.csv";
    public static final String POKEDEX = "Pokedex.txt";

    public static void main(String[] args) {
        ArrayList<BaseStatsObject> baseStats = parseBaseStatsData(BASE_STATS);
        ArrayList<MoveListObject> moveLists = parseMoveListData(MOVE_LIST);
        ArrayList<PokedexObject> pokedexs = parsePokedexData(POKEDEX);


    }

    private static ArrayList<PokedexObject> parsePokedexData(String path) {
        ArrayList<PokedexObject> data = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String s;
            PokedexObject po = null;
            while ((s = br.readLine()) != null) {
                if (s.trim().length() == 0) continue;
                if (s.startsWith("#")) {
                    po = PokedexObject.create(s);
                    data.add(po);
                } else {
                    if (po != null) po.addSkill(s);
                }
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ignored) {

                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ignored) {

                }
            }
        }
        return data;
    }

    private static ArrayList<MoveListObject> parseMoveListData(String path) {
        ArrayList<MoveListObject> data = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String s = br.readLine();
            while ((s = br.readLine()) != null) {
                MoveListObject mlo = MoveListObject.create(s);
                if (mlo != null) data.add(mlo);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ignored) {

                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ignored) {

                }
            }
        }
        return data;
    }

    private static ArrayList<BaseStatsObject> parseBaseStatsData(String path) {
        ArrayList<BaseStatsObject> data = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String s = br.readLine();
            while ((s = br.readLine()) != null) {
                BaseStatsObject bso = BaseStatsObject.create(s);
                if (bso != null) data.add(bso);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ignored) {

                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ignored) {

                }
            }
        }
        return data;
    }
}
