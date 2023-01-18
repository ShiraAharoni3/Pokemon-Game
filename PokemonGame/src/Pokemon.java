public abstract class Pokemon
{
    public String Name = "";
    public int level ;
    public int maxLifePoints ;
    public int attackPoints ;
    public int costAttack ;
    public int damageToTheOpponent ;
    public boolean bonus ;
    public abstract void specialAction();
    public abstract boolean attack( );
    public abstract void waitingPock() ;
    public abstract boolean attacked( int damagePoint );
    static final int MAX_ADDITION_POINT = 4;
    static final int MIN_ADDITION_POINT = 0;

    public void additionLifePointToPlayer ( Pokemon player )
    {
        int additionLifePoint;
        additionLifePoint = (int) (Math.random() * (MAX_ADDITION_POINT - MIN_ADDITION_POINT + 1) + MIN_ADDITION_POINT);
        player.maxLifePoints += additionLifePoint;
    }

    public void additionAttackPointToPlayer (Pokemon player )
    {
        int additionAttackPoint;
        additionAttackPoint = (int) (Math.random() * (MAX_ADDITION_POINT - MIN_ADDITION_POINT + 1) + MIN_ADDITION_POINT);
        player.attackPoints += additionAttackPoint ;

    }

    public abstract int upLevel() ;
    static final int LIFE_POINT_TO_LEVEL_UP2 = 20;
    static final int ATTACK_POINT_TO_LEVEL_UP2 = 25;
    static final int LIFE_POINT_TO_LEVEL_UP3 = 30;
    static final int ATTACK_POINT_TO_LEVEL_UP3 = 40;





    Pokemon (){}
}

