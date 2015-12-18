package firedingo.mod.HoverBoards.entity;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import firedingo.mod.HoverBoards.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Firedingo on 9/10/2015.
 */
public class EntityHoverBoard extends EntityCreature {

    private double speedMultiplier;
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    @SideOnly(Side.CLIENT)
    private double velocityX;
    @SideOnly(Side.CLIENT)
    private double velocityY;
    @SideOnly(Side.CLIENT)
    private double velocityZ;

    public EntityHoverBoard(World world) {
        super(world);
        this.setSize(2.0F, 0.8F); //hitbox
        this.boundingBox.offset(0,0.5,0);
        this.boundingBox.setBounds(1.0, 0.8, 2.0,1.0, 0.8, 2.0);
        this.getCollisionBox(this);
        this.ridingEntity = null;
        this.riddenByEntity = null;
        this.setHealth(0.5F);
        this.speedMultiplier = 0.07D;
        this.getBrightness(0.2F);


    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public void dismountEntity(Entity p_110145_1_) {
        super.dismountEntity(p_110145_1_);
    }

    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        return super.getCanSpawnHere() && this.getBlockPathWeight(i, j, k) >= 0.0F;
    }

    @Override
    protected void damageEntity(DamageSource damageSource, float amount) {
        this.setHealth(this.prevHealth - amount);
       // super.damageEntity(damageSource, amount);
    }

    @Override
    public void setDead() {
        if (this.getHealth() == 0) {
            super.setDead();
        }

    }

    @Override
    public double getMountedYOffset() {
        return this.height + 0.5;
       // return super.getMountedYOffset();
    }

    protected boolean isMovementCeased()
    {
        return true;
    }

  /*  protected void entityInit()
    {
      //  this.dataWatcher.addObject(29, 1);//HitTime
      //  this.dataWatcher.addObject(30, new Integer(0));
      //  this.dataWatcher.addObject(31, new Float(0.0F));//DamageTaken
    } */

/*    public int getTimeSinceHit()
    {
        return this.dataWatcher.getWatchableObjectInt(29);
    }

    public void setTimeSinceHit(int p_70265_1_)
    {
        this.dataWatcher.updateObject(29, Integer.valueOf(p_70265_1_));
    }

    public void setDamageTaken(float p_70266_1_)
    {
        this.dataWatcher.updateObject(31, Float.valueOf(p_70266_1_));
    }

    public float getDamageTaken()
    {
        return this.dataWatcher.getWatchableObjectFloat(31);
    } */

   /* @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_)
    {
        if (this.riddenByEntity != null)
        {
            this.boatPosRotationIncrements = p_70056_9_ + 5;
        }
        else
        {
            double d3 = p_70056_1_ - this.posX;
            double d4 = p_70056_3_ - this.posY;
            double d5 = p_70056_5_ - this.posZ;
            double d6 = d3 * d3 + d4 * d4 + d5 * d5;

            if (d6 <= 1.0D)
            {
                return;
            }

            this.boatPosRotationIncrements = 3;
        }

        this.boatX = p_70056_1_;
        this.boatY = p_70056_3_;
        this.boatZ = p_70056_5_;
        this.boatYaw = (double)p_70056_7_;
        this.boatPitch = (double)p_70056_8_;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    } */



    @Override
    public void onUpdate() {

    }



    @Override
    public void moveEntity(double x, double y, double z) {

        if (this.posX != x && this.posY != y && this.posZ != z) {
            super.moveEntity(x, y, z);
        }

    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        applyEntityCollision(player);
       // super.onCollideWithPlayer(player);
    }
    public void applyEntityCollision(Entity entity)
    {
        if (entity.riddenByEntity != this && entity.ridingEntity != this)
        {
            double d0 = entity.posX - this.posX - 1;
            double d1 = entity.posZ - this.posZ - 1;
            double d2 = MathHelper.abs_max(d0, d1);

            if (d2 >= 0.009999999776482582D)
            {
                d2 = (double)MathHelper.sqrt_double(d2);
                d0 /= d2;
                d1 /= d2;
                double d3 = 1.0D / d2;

                if (d3 > 1.0D)
                {
                    d3 = 1.0D;
                }

                d0 *= d3;
                d1 *= d3;
                d0 *= 0.05000000074505806D;
                d1 *= 0.05000000074505806D;
                d0 *= (double)(1.0F - this.entityCollisionReduction);
                d1 *= (double)(1.0F - this.entityCollisionReduction);
                this.addVelocity(-d0, 0.0D, -d1);
                entity.addVelocity(d0, 0.0D, d1);
            }
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean writeMountToNBT(NBTTagCompound NBTtag) {
        String EntityID = this.getEntityString();
        if (EntityID != null) {
            NBTtag.setString("ID", EntityID);
            this.writeToNBT(NBTtag);
            return true;
        }
        return false;
        //isRmote = true for client, false for server
        //return super.writeMountToNBT(p_98035_1_);
    }

    @Override //work on all this NBT stuff
    public void readFromNBT(NBTTagCompound NBTtag) {
        NBTTagList TagList = NBTtag.getTagList("ID",1);
        super.readFromNBT(NBTtag);
    }

    @Override
    public void updateRidden() {
        super.updateRidden();
    }

    @Override
    public void updateRiderPosition() {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ);
        }
       // super.updateRiderPosition();
    }

    @Override
    public boolean interact(EntityPlayer player) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != player)
        {
            return true;
        }
        else
        {
            if (!this.worldObj.isRemote)
            {
              /*  if () {
                    super.shouldRiderSit();
                    player.mountEntity(this);
                } */
                player.mountEntity(this);
            }

            return true;
        }
    }


    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    public void onDeath(DamageSource p_70645_1_) {
        super.onDeath(p_70645_1_);
    }



    @Override
    public EntityItem entityDropItem(ItemStack stack, float shadow) {
        if (isDead == true) {
            //stack = something;
            stack.getItem();
            return super.entityDropItem(stack, 0.5F);
          //  return super.entityDropItem(stack, p_70099_2_);
        }
        return super.entityDropItem(stack, 0F);
    }
}
