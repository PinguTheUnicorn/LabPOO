public class FortyStrategy implements Strategy{
    @Override
    public float calcul(int aniVechime, float salariu) {
        return ((float)aniVechime / 40) * salariu;
    }
}
