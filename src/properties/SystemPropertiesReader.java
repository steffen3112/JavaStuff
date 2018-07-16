package properties;

import java.util.*;

public class SystemPropertiesReader {

    private final Map<String, String> sysProps;
    private final Map<String, String> sysEnvs;

    SystemPropertiesReader (){
        Properties properties = System.getProperties();
        sysProps = new TreeMap(properties);
        sysEnvs = new TreeMap<>(System.getenv());
    }

    List<String> readProps() {
        List<String> stringList = new LinkedList<>();
        int i = 0;
        for (Map.Entry<String, String> stringMap : sysProps.entrySet()) {
            i++;
            stringList.add("Prop. " + i + "\tkey: "  + stringMap.getKey() + "\tval: " + stringMap.getValue());
        }
        return stringList;
    }


    List<String> readEnvs() {
        List<String> stringList = new LinkedList<>();
        int i = 0;
        for (Map.Entry<String, String> stringMap : sysEnvs.entrySet()) {
            i++;
            stringList.add("Envs. " + i + "\tkey: "  + stringMap.getKey() + "\tval: " + stringMap.getValue());
            stringList.add("Envs. A BAD VALUE");
        }
        return stringList;
    }

    public static void main(String[] args) {

        SystemPropertiesReader systemPropertiesReader = new SystemPropertiesReader();
        List<String> props = systemPropertiesReader.readProps();
        //props.parallelStream().forEach(System.out::println);

        List<String> envs = systemPropertiesReader.readProps();
        //envs.forEach(System.out::println);


    }

}
