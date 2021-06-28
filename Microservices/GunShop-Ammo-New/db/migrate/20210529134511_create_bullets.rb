class CreateBullets < ActiveRecord::Migration[6.1]
  def change
    create_table :bullets do |t|
      t.integer :velocity
      t.string :brand

      t.timestamps
    end
  end
end
