import java.util.Random;

public abstract class FiresPokemons extends Pokemon
{
    public int AttackerPokemon ()
    {
        Random random = new Random();
        int randomDamage = 0 ;
        int minAttack = 3 ;
        int maxAttack = 10 ;
        int Damaged = (int) (Math.random() * (maxAttack - minAttack + 1) + minAttack);
        randomDamage = Damaged ;
        return Damaged;
    }



    FiresPokemons( )
    {

    }
}
