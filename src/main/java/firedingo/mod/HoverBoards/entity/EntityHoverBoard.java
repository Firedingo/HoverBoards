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
import net.minecraft.entity.EntityLivingBase;
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

    public EntityHoverBoard(World world) {
        super(world);
        this.setSize(2.0F, 0.8F); //hitbox
        this.boundingBox.offset(0,0.5,0);
        this.boundingBox.setBounds(1.0, 0.8, 2.0,1.0, 0.8, 2.0);
        this.getCollisionBox(this);
        this.ridingEntity = null;
        this.riddenByEntity = null;
        this.setHealth(0.5F);
        //this.speedMultiplier = 0.07D;
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
    public double getMountedYOffset() {
        return this.height + 0.5;
        // return super.getMountedYOffset();
    }
    protected boolean isMovementCeased()
    {
        return true;
    }
    @Override
    protected boolean canTriggerWalking() {
        return false;
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
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
         //super.updateRiderPosition();
    }
    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }
    @Override
    public void onDeath(DamageSource p_70645_1_) {

        // ItemStack stack = Itemstack(ModItems.ItemHoverBoard);
        // stack.getItem();
        if (this.getHealth() <= 0) {
            entityDropItem(new ItemStack(ModItems.ItemHoverBoard), 0.5F);
        }
        // super.onDeath(p_70645_1_);

    }
    @Override
    public void moveEntity(double x, double y, double z) {

        if (true) {
            if (this.getHealth() > 0) {
                if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase) {
                    this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
                    this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
                    this.setRotation(this.rotationYaw, this.rotationPitch);
                    this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
                    this.motionX += riddenByEntity.motionX;
                    this.motionZ += riddenByEntity.motionZ;
                    this.motionY += riddenByEntity.motionY;


                    if (this.onGround == true) {
                        if (true) {
                            //dismount here
                        }
                    }


                }
            }
        }

        //Flying code
        /*
        float f3 = x * x + z * z;

        if (f3 >= 1.0E-4F)
        {
            f3 = MathHelper.sqrt_float(f3);

            if (f3 < 1.0F)
            {
                f3 = 1.0F;
            }

            f3 = y / f3;
            x *= f3;
            z *= f3;
            float f4 = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F);
            float f5 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F);
            this.motionX += (double)(x * f5 - z * f4);
            this.motionZ += (double)(z * f5 + x * f4);
        }
        */

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
       /* if (damageSource == DamageSource.generic) {
            if (this.prevHealth > 0) {
              //  this.setHealth(this.prevHealth / 2);
                this.setHealth(this.prevHealth - amount);
            }
        } */

        this.setHealth(this.prevHealth - amount);
        super.damageEntity(damageSource, amount);
    }
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        this.applyEntityCollision(player);
        // super.onCollideWithPlayer(player);
    }

    @Override
    public void applyEntityCollision(Entity entity) //need to fix this up slightly but it's functionable
    {

        if (entity.riddenByEntity != this && entity.ridingEntity != this)
        {
            double d0 = entity.posX - this.posX - 1D;
            double d1 = entity.posZ - this.posZ - 1D;
            double d2 = MathHelper.abs_max(d0, d1) - 1D;

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
}
