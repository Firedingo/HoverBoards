package firedingo.mod.HoverBoards.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Hoverboard - Firedingo
 * Created using Tabula 4.1.1
 */
public class Hoverboard extends ModelBase {
    public ModelRenderer OverBody;
    public ModelRenderer Backend1;
    public ModelRenderer Backend2;
    public ModelRenderer Frontend;
    public ModelRenderer UnderBody;
    public ModelRenderer Backend1_1;
    public ModelRenderer Backend2_1;
    public ModelRenderer Frontend_1;
    public ModelRenderer PowerCrystal1;
    public ModelRenderer PowerCrystal2;
    public ModelRenderer PowerCrystal3;

    public Hoverboard() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.PowerCrystal2 = new ModelRenderer(this, 0, 0);
        this.PowerCrystal2.setRotationPoint(1.0F, 14.2F, -2.2F);
        this.PowerCrystal2.addBox(-3.0F, -1.0F, 0.5F, 2, 2, 2, 0.0F);
        this.setRotateAngle(PowerCrystal2, 0.0F, 0.767944870877505F, 0.0F);
        this.Backend2 = new ModelRenderer(this, 10, 0);
        this.Backend2.setRotationPoint(16.9F, 12.0F, 5.9F);
        this.Backend2.addBox(-14.0F, -0.5F, -0.5F, 12, 1, 1, 0.0F);
        this.setRotateAngle(Backend2, 0.0F, 0.767944870877505F, 0.0F);
        this.PowerCrystal3 = new ModelRenderer(this, 0, 0);
        this.PowerCrystal3.setRotationPoint(7.6F, 14.2F, 4.6F);
        this.PowerCrystal3.addBox(-3.0F, -1.0F, 1.5F, 2, 2, 2, 0.0F);
        this.setRotateAngle(PowerCrystal3, 0.0F, 0.767944870877505F, 0.0F);
        this.PowerCrystal1 = new ModelRenderer(this, 0, 0);
        this.PowerCrystal1.setRotationPoint(-6.4F, 14.2F, -9.7F);
        this.PowerCrystal1.addBox(-3.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
        this.setRotateAngle(PowerCrystal1, 0.0F, 0.767944870877505F, 0.0F);
        this.OverBody = new ModelRenderer(this, 0, 0);
        this.OverBody.setRotationPoint(4.3F, 12.0F, -5.5F);
        this.OverBody.addBox(-14.9F, -0.5F, -13.5F, 16, 1, 29, 0.0F);
        this.setRotateAngle(OverBody, 0.0F, 0.767944870877505F, 0.0F);
        this.Backend2_1 = new ModelRenderer(this, 8, 0);
        this.Backend2_1.setRotationPoint(12.0F, 13.0F, 8.8F);
        this.Backend2_1.addBox(-7.3F, -0.5F, -0.3F, 10, 1, 1, 0.0F);
        this.setRotateAngle(Backend2_1, 0.0F, 0.767944870877505F, 0.0F);
        this.UnderBody = new ModelRenderer(this, 0, 0);
        this.UnderBody.setRotationPoint(-6.9F, 13.0F, -10.0F);
        this.UnderBody.addBox(-8.8F, -0.5F, -1.6F, 14, 1, 27, 0.0F);
        this.setRotateAngle(UnderBody, 0.0F, 0.767944870877505F, 0.0F);
        this.Frontend_1 = new ModelRenderer(this, 7, 0);
        this.Frontend_1.setRotationPoint(-8.7F, 13.0F, -11.2F);
        this.Frontend_1.addBox(-7.3F, -0.5F, -0.5F, 12, 1, 1, 0.0F);
        this.setRotateAngle(Frontend_1, 0.0F, 0.767944870877505F, 0.0F);
        this.Backend1_1 = new ModelRenderer(this, 7, 0);
        this.Backend1_1.setRotationPoint(10.8F, 13.0F, 8.9F);
        this.Backend1_1.addBox(-7.4F, -0.5F, -0.5F, 12, 1, 1, 0.0F);
        this.setRotateAngle(Backend1_1, 0.0F, 0.767944870877505F, 0.0F);
        this.Frontend = new ModelRenderer(this, 9, 0);
        this.Frontend.setRotationPoint(-4.1F, 12.0F, -16.8F);
        this.Frontend.addBox(-15.7F, -0.5F, -0.5F, 14, 1, 1, 0.0F);
        this.setRotateAngle(Frontend, 0.0F, 0.767944870877505F, 0.0F);
        this.Backend1 = new ModelRenderer(this, 9, 0);
        this.Backend1.setRotationPoint(16.2F, 12.0F, 5.2F);
        this.Backend1.addBox(-15.0F, -0.5F, -0.5F, 14, 1, 1, 0.0F);
        this.setRotateAngle(Backend1, 0.0F, 0.767944870877505F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.PowerCrystal2.render(f5);
        this.Backend2.render(f5);
        this.PowerCrystal3.render(f5);
        this.PowerCrystal1.render(f5);
        this.OverBody.render(f5);
        this.Backend2_1.render(f5);
        this.UnderBody.render(f5);
        this.Frontend_1.render(f5);
        this.Backend1_1.render(f5);
        this.Frontend.render(f5);
        this.Backend1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
