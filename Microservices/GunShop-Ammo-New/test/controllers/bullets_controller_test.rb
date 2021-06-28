require "test_helper"

class BulletsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @bullet = bullets(:one)
  end

  test "should get index" do
    get bullets_url, as: :json
    assert_response :success
  end

  test "should create bullet" do
    assert_difference('Bullet.count') do
      post bullets_url, params: { bullet: { brand: @bullet.brand, velocity: @bullet.velocity } }, as: :json
    end

    assert_response 201
  end

  test "should show bullet" do
    get bullet_url(@bullet), as: :json
    assert_response :success
  end

  test "should update bullet" do
    patch bullet_url(@bullet), params: { bullet: { brand: @bullet.brand, velocity: @bullet.velocity } }, as: :json
    assert_response 200
  end

  test "should destroy bullet" do
    assert_difference('Bullet.count', -1) do
      delete bullet_url(@bullet), as: :json
    end

    assert_response 204
  end
end
