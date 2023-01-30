package tema;

public abstract class Spell implements Visitor<Entity> {
    int damage;
    int costMana;
}

class Ice extends Spell{
    public Ice()
    {
        damage = 15;
        costMana = 20;
    }

    @Override
    public void visit(Entity entity) {
        if ( entity.protectieIce == false) entity.receiveDamage(damage);
    }
}

class Fire extends Spell{
    public Fire()
    {
        damage = 10;
        costMana = 5;
    }
    @Override
    public void visit(Entity entity) {
        if ( entity.protectieFire == false) entity.receiveDamage(damage);
    }
}

class Earth extends Spell{
    public Earth()
    {
        damage = 15;
        costMana = 12;
    }
    @Override
    public void visit(Entity entity) {
        if ( entity.protectieEarth== false) entity.receiveDamage(damage);
    }
}