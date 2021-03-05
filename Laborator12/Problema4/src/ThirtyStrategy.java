public class ThirtyStrategy implements Strategy {
    @Override
    public float calcul(int aniVechime, float salariu) {
        return ((float)aniVechime / 30) * salariu;
    }
}
