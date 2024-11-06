import java.util.ArrayList;

public class TelephoneDirectory {
    private class Record {
        private String surname;
        private String phone;

        public Record(String surname, String phone) {
            this.surname = surname;
            this.phone = phone;
        }

        public String getSurname() {
            return surname;
        }

        public String getPhone() {
            return phone;
        }
    }

    ArrayList<Record> directory;

    public TelephoneDirectory() {
        this.directory = new ArrayList<Record>();
    }

    public void add(String surname, String phone) {
        Record record = new Record(surname, phone);
        directory.add(record);
    }

    public ArrayList<String> get(String surname) {
        ArrayList<String> phone = new ArrayList<String>();
        for (Record record : directory) {
            if (record.getSurname().equals(surname)) {
                phone.add(record.getPhone());
            }
        }
        return phone;
    }
}
