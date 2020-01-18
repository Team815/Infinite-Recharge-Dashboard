package frc.team815.infinite_recharge.dashboard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Dashboard extends ApplicationAdapter {
	Stage stage;
	Skin skin;
	SpriteBatch batch;
	float x = 0;
	float y = 0;
	float speed = 5;
	
	@Override
	public void create () {
		stage = new Stage();
		skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		batch = new SpriteBatch();
		Image logoInfiniteRecharge = new Image(new Texture("LogoInfiniteRechargeWhite.png"));
		stage.addActor(logoInfiniteRecharge);
		logoInfiniteRecharge.setScale(0.2f);
		logoInfiniteRecharge.setPosition(970, 600);
		Image logoTeam815 = new Image(new Texture("LogoTeam815.png"));
		stage.addActor(logoTeam815);
		logoTeam815.setScale(0.1f);
		logoTeam815.setPosition(10, 580);
		final TextButton button = new TextButton("Click me", skin);
		button.setSize(200, 20);
		button.setPosition(400,160);
		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				button.setText("Connected");
			}
		});
		Slider slider = new Slider(0, 10, 0.01f, false, skin);
		slider.setWidth(200);
		slider.setPosition(400, 200);
		stage.addActor(button);
		stage.addActor(slider);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		stage.draw();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();
		skin.dispose();
	}
}
