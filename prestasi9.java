import java.util.Scanner;

public class prestasi9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[][] dataPrestasi = new String[100][5];
        int jumlahData = 0;
        int pilihan;

        do {
            System.out.println("\n=================================================");
            System.out.println("\n========= PENCATATAN PRESTASI MAHASISWA =========");
            System.out.println("\n=================================================");
            System.out.println("1. Tambah Data Prestasi");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahData >= dataPrestasi.length) {
                        System.out.println("Kapasitas data penuh. Tidak dapat menambahkan data lagi.");
                        break;
                    }

                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    while (nama.trim().isEmpty()) {
                        System.out.print("Nama tidak boleh kosong. Masukkan Nama Mahasiswa: ");
                        nama = scanner.nextLine();
                    }
                    dataPrestasi[jumlahData][0] = nama;

                    System.out.print("Masukkan NIM Mahasiswa (12 digit): ");
                    String nim = scanner.nextLine();
                    while (!nim.matches("\\d{12}")) {
                        System.out.print("NIM harus terdiri dari 12 digit angka. Masukkan NIM Mahasiswa (12 digit): ");
                        nim = scanner.nextLine();
                    }
                    dataPrestasi[jumlahData][1] = nim;

                    System.out.print("Masukkan Jenis Prestasi (Juara 1/Juara 2/Juara 3): ");
                    String jenisPrestasi = scanner.nextLine();
                    while (!jenisPrestasi.equalsIgnoreCase("Juara 1") && 
                           !jenisPrestasi.equalsIgnoreCase("Juara 2") && 
                           !jenisPrestasi.equalsIgnoreCase("Juara 3")) {
                        System.out.print("Jenis prestasi tidak valid. Masukkan Jenis Prestasi (Juara 1/Juara 2/Juara 3): ");
                        jenisPrestasi = scanner.nextLine();
                    }
                    dataPrestasi[jumlahData][2] = jenisPrestasi;

                    System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
                    String tingkatPrestasi = scanner.nextLine();
                    while (!tingkatPrestasi.equalsIgnoreCase("Lokal") && 
                           !tingkatPrestasi.equalsIgnoreCase("Nasional") && 
                           !tingkatPrestasi.equalsIgnoreCase("Internasional")) {
                        System.out.print("Tingkat prestasi tidak valid. Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
                        tingkatPrestasi = scanner.nextLine();
                    }
                    dataPrestasi[jumlahData][3] = tingkatPrestasi;

                    System.out.print("Masukkan Tahun Prestasi (2000 - 2024): ");
                    int tahunPrestasi = scanner.nextInt();
                    while (tahunPrestasi < 2000 || tahunPrestasi > 2024) {
                        System.out.print("Tahun tidak valid. Masukkan Tahun Prestasi (2000 - 2024): ");
                        tahunPrestasi = scanner.nextInt();
                    }
                    dataPrestasi[jumlahData][4] = String.valueOf(tahunPrestasi);
                    scanner.nextLine();

                    jumlahData++;
                    System.out.println("Data prestasi berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.println("\n=== DATA SEMUA PRESTASI ===");
                    if (jumlahData == 0) {
                        System.out.println("Belum ada data prestasi.");
                    } else {
                        for (int i = 0; i < jumlahData; i++) {
                            System.out.println("Nama: " + dataPrestasi[i][0] + " | NIM: " + dataPrestasi[i][1] +
                                    " | Jenis: " + dataPrestasi[i][2] + " | Tingkat: " + dataPrestasi[i][3] +
                                    " | Tahun: " + dataPrestasi[i][4]);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan Jenis Prestasi yang ingin dianalisis: ");
                    String jenisAnalisis = scanner.nextLine();
                    System.out.println("\n=== ANALISIS PRESTASI ===");
                    boolean ditemukan = false;

                    for (int i = 0; i < jumlahData; i++) {
                        if (dataPrestasi[i][2].equalsIgnoreCase(jenisAnalisis)) {
                            System.out.println("Nama: " + dataPrestasi[i][0] + " | NIM: " + dataPrestasi[i][1] +
                                    " | Tingkat: " + dataPrestasi[i][3] + " | Tahun: " + dataPrestasi[i][4]);
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Tidak ada data prestasi dengan jenis tersebut.");
                    }
                    break;

                case 4:
                    System.out.println("Program selesai.");
                    System.out.println("Terima kasih atas data yang anda berikan");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. ulang goblokk!");
                    break;
            }
        } while (pilihan != 4);
    }
}
